@echo off
setlocal enabledelayedexpansion

:: run_auto_tests.bat
:: Purpose: compile, start the app in a separate window, wait for port 8080,
:: run test_endpoints.bat, then stop the server and save logs.

set SCRIPT_DIR=%~dp0
set PROJECT_DIR=%SCRIPT_DIR%
set LOG=%SCRIPT_DIR%..\auto_test.log
set SERVER_LOG=%SCRIPT_DIR%..\server_output.log

echo ===== Auto Test - %date% %time% > "%LOG%"
echo Script running from: %SCRIPT_DIR% >> "%LOG%"

echo Compiling project... >> "%LOG%"
mvn -q clean compile >> "%LOG%" 2>&1
if errorlevel 1 (
  echo Build failed. Check %LOG%
  echo Build failed. >> "%LOG%"
  pause
  exit /b 1
)

echo Build successful. >> "%LOG%"
echo Starting server... >> "%LOG%"

:: Start server in a new window and redirect its output to a log file
start "TalleresServer" cmd /c "cd /d "%PROJECT_DIR%" && mvn spring-boot:run > "%SERVER_LOG%" 2>&1"

:: Wait for server to respond on port 8080 (timeout 60s)
echo Waiting for server on port 8080... >> "%LOG%"
set WAITED=0
:WAIT_LOOP
  powershell -Command "if ((Test-NetConnection -ComputerName 'localhost' -Port 8080).TcpTestSucceeded) { exit 0 } else { exit 1 }" >nul 2>&1
  if %errorlevel% equ 0 (
    echo Server is up. >> "%LOG%"
    goto RUN_TESTS
  )
  set /a WAITED+=1
  if %WAITED% geq 60 (
    echo Server did not start within 60 seconds. >> "%LOG%"
    echo Check server logs in %SERVER_LOG%
    pause
    exit /b 1
  )
  timeout /t 1 /nobreak >nul
  goto WAIT_LOOP

:RUN_TESTS
  echo Running tests (test_endpoints.bat)... >> "%LOG%"
  cd /d "%SCRIPT_DIR%.."
  call "test_endpoints.bat" >> "%LOG%" 2>&1
  echo Tests completed at %date% %time% >> "%LOG%"

  :: Attempt to close the server window by window title
  echo Attempting to stop server window titled "TalleresServer"... >> "%LOG%"
  taskkill /FI "WINDOWTITLE eq TalleresServer - cmd.exe" /T /F >> "%LOG%" 2>&1
  if errorlevel 1 (
    echo Could not kill by window title; attempting to kill java.exe... >> "%LOG%"
    taskkill /IM java.exe /F >> "%LOG%" 2>&1
  ) else (
    echo Server window killed. >> "%LOG%"
  )

  echo Auto-test finished. See %LOG% for details.
  echo Auto-test finished at %date% %time% >> "%LOG%"
  pause
endlocal
exit /b 0
