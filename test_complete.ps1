#!/usr/bin/env pwsh
# Script de prueba completo para todos los módulos del Sistema de Gestión de Talleres

$baseUrl = "http://localhost:8080"
$userTokens = @{}

Write-Host "╔════════════════════════════════════════════════════════════════╗" -ForegroundColor Cyan
Write-Host "║  PRUEBAS - Sistema de Gestión de Talleres y Seminarios        ║" -ForegroundColor Cyan
Write-Host "║  URL Base: $baseUrl" -ForegroundColor Cyan
Write-Host "╚════════════════════════════════════════════════════════════════╝" -ForegroundColor Cyan

# Función auxiliar para hacer requests
function Invoke-API {
    param(
        [string]$Method = "GET",
        [string]$Endpoint,
        [hashtable]$Headers = @{},
        [string]$Body = $null
    )
    
    $url = "$baseUrl$Endpoint"
    $defaultHeaders = @{'Content-Type' = 'application/json'}
    $mergedHeaders = $defaultHeaders + $Headers
    
    try {
        $params = @{
            Uri = $url
            Method = $Method
            Headers = $mergedHeaders
        }
        if ($Body) { $params['Body'] = $Body }
        
        $response = Invoke-WebRequest @params
        return $response.Content | ConvertFrom-Json
    }
    catch {
        Write-Host "ERROR: $($_.Exception.Message)" -ForegroundColor Red
        if ($_.Exception.Response) {
            $reader = New-Object System.IO.StreamReader($_.Exception.Response.GetResponseStream())
            $errorBody = $reader.ReadToEnd()
            Write-Host "Respuesta: $errorBody" -ForegroundColor Red
        }
        return $null
    }
}

Write-Host "`n[1] AUTENTICACIÓN" -ForegroundColor Yellow

# Registrar usuario participante
Write-Host "  → Registrando participante 'luis'..." -ForegroundColor Gray
$participant1 = Invoke-API -Method POST -Endpoint "/api/auth/register" -Body @{
    username = "luis"
    email = "luis@test.com"
    password = "luis123"
    rol = "ROLE_PARTICIPANTE"
} | ConvertTo-Json

Write-Host "  ✓ Participante registrado" -ForegroundColor Green

# Registrar usuario ponente
Write-Host "  → Registrando ponente 'sofia'..." -ForegroundColor Gray
$ponente1 = Invoke-API -Method POST -Endpoint "/api/auth/register" -Body @{
    username = "sofia"
    email = "sofia@test.com"
    password = "sofia123"
    rol = "ROLE_PONENTE"
} | ConvertTo-Json

Write-Host "  ✓ Ponente registrado" -ForegroundColor Green

# Login participante
Write-Host "  → Login participante 'luis'..." -ForegroundColor Gray
$luisLogin = Invoke-API -Method POST -Endpoint "/api/auth/login" -Body @{
    username = "luis"
    password = "luis123"
} | ConvertTo-Json -AsString | ConvertFrom-Json
$userTokens['luis'] = $luisLogin.token
Write-Host "  ✓ Token obtenido: $($luisLogin.token.Substring(0, 30))..." -ForegroundColor Green

# Login ponente
Write-Host "  → Login ponente 'sofia'..." -ForegroundColor Gray
$sofiaLogin = Invoke-API -Method POST -Endpoint "/api/auth/login" -Body @{
    username = "sofia"
    password = "sofia123"
} | ConvertTo-Json -AsString | ConvertFrom-Json
$userTokens['sofia'] = $sofiaLogin.token
Write-Host "  ✓ Token obtenido: $($sofiaLogin.token.Substring(0, 30))..." -ForegroundColor Green

Write-Host "`n[2] MÓDULO EVENTOS (PUBLIC)" -ForegroundColor Yellow

# Listar eventos
Write-Host "  → Obteniendo lista de eventos (público)..." -ForegroundColor Gray
$eventos = Invoke-API -Method GET -Endpoint "/api/eventos"
Write-Host "  ✓ Eventos disponibles: $($eventos.Count)" -ForegroundColor Green
if ($eventos) {
    $eventos | ForEach-Object { Write-Host "    - ID: $($_.id), Título: $($_.titulo), Inscritos: $($_.inscritos)" -ForegroundColor Gray }
}

Write-Host "`n[3] MÓDULO PONENTES" -ForegroundColor Yellow

# Registrar perfil ponente
Write-Host "  → Registrando perfil de ponente..." -ForegroundColor Gray
$perfilPonente = Invoke-API -Method POST -Endpoint "/api/ponentes/register" `
    -Headers @{'Authorization' = "Bearer $($userTokens['sofia'])"} `
    -Body @{
        nombre = "Sofía Martínez"
        bio = "Experta en arquitectura de software"
        fotoUrl = "https://example.com/sofia.jpg"
    } | ConvertTo-Json -AsString | ConvertFrom-Json

if ($perfilPonente) {
    Write-Host "  ✓ Perfil creado (ID: $($perfilPonente.id))" -ForegroundColor Green
}

# Crear evento como ponente
Write-Host "  → Creando evento como ponente..." -ForegroundColor Gray
$eventoCreado = Invoke-API -Method POST -Endpoint "/api/eventos" `
    -Headers @{'Authorization' = "Bearer $($userTokens['sofia'])"} `
    -Body @{
        titulo = "Clean Code Masterclass"
        tipo = "TALLER"
        modalidad = "PRESENCIAL"
        sede = "Medellín"
        estado = "ABIERTO"
        precio = 250000
        capacidad = 30
    } | ConvertTo-Json -AsString | ConvertFrom-Json

if ($eventoCreado) {
    Write-Host "  ✓ Evento creado (ID: $($eventoCreado.id))" -ForegroundColor Green
}

Write-Host "`n[4] MÓDULO PARTICIPANTES" -ForegroundColor Yellow

# Listar participantes
Write-Host "  → Obteniendo lista de participantes..." -ForegroundColor Gray
$participantes = Invoke-API -Method GET -Endpoint "/api/participantes"
Write-Host "  ✓ Participantes registrados: $($participantes.Count)" -ForegroundColor Green
if ($participantes) {
    $participantes | ForEach-Object { Write-Host "    - ID: $($_.id), Nombre: $($_.nombre)" -ForegroundColor Gray }
}

Write-Host "`n[5] INSCRIPCIONES" -ForegroundColor Yellow

# Inscribirse en evento
Write-Host "  → Inscribiendo participante en evento..." -ForegroundColor Gray
if ($participantes -and $participantes.Count -gt 0 -and $eventoCreado) {
    $inscripcion = Invoke-API -Method POST -Endpoint "/api/inscripciones/register" `
        -Headers @{'Authorization' = "Bearer $($userTokens['luis'])"} `
        -Body @{
            participanteId = $participantes[0].id
            eventoId = $eventoCreado.id
        } | ConvertTo-Json -AsString | ConvertFrom-Json
    
    if ($inscripcion) {
        Write-Host "  ✓ Inscripción realizada (ID: $($inscripcion.id), Estado: $($inscripcion.estado))" -ForegroundColor Green
    }
}

# Listar inscripciones
Write-Host "  → Obteniendo lista de inscripciones..." -ForegroundColor Gray
$inscripciones = Invoke-API -Method GET -Endpoint "/api/inscripciones" `
    -Headers @{'Authorization' = "Bearer $($userTokens['luis'])"}
Write-Host "  ✓ Inscripciones: $($inscripciones.Count)" -ForegroundColor Green
if ($inscripciones) {
    $inscripciones | ForEach-Object { Write-Host "    - ID: $($_.id), Participante: $($_.participanteNombre), Evento: $($_.eventoTitulo)" -ForegroundColor Gray }
}

Write-Host "`n[6] LISTAR INSCRITOS (PONENTE)" -ForegroundColor Yellow

# Listar inscritos por ponente
Write-Host "  → Obteniendo inscritos en evento (como ponente)..." -ForegroundColor Gray
if ($perfilPonente -and $eventoCreado) {
    $inscritos = Invoke-API -Method GET -Endpoint "/api/ponentes/$($perfilPonente.id)/inscritos/$($eventoCreado.id)" `
        -Headers @{'Authorization' = "Bearer $($userTokens['sofia'])"}
    
    if ($inscritos) {
        Write-Host "  ✓ Inscritos en evento: $($inscritos.Count)" -ForegroundColor Green
        $inscritos | ForEach-Object { Write-Host "    - $($_.participanteNombre) ($($_.participanteId))" -ForegroundColor Gray }
    }
}

Write-Host "`n╔════════════════════════════════════════════════════════════════╗" -ForegroundColor Cyan
Write-Host "║                    PRUEBAS COMPLETADAS                        ║" -ForegroundColor Cyan
Write-Host "╚════════════════════════════════════════════════════════════════╝" -ForegroundColor Cyan

Write-Host "`nENDPOINTS DISPONIBLES:" -ForegroundColor Yellow
Write-Host @"
┌─ AUTENTICACIÓN
│  POST   /api/auth/register          Registrar usuario nuevo
│  POST   /api/auth/login             Login y obtener JWT token
│
├─ EVENTOS (públicos para GET)
│  GET    /api/eventos                Listar todos eventos
│  GET    /api/eventos/{id}           Obtener detalle evento
│  POST   /api/eventos                Crear evento (ROLE_PONENTE|ADMIN)
│
├─ PARTICIPANTES
│  GET    /api/participantes          Listar todos
│  GET    /api/participantes/{id}     Obtener detalle
│  POST   /api/participantes/register Registrar participante
│  GET    /api/participantes/{id}/inscripciones
│
├─ PONENTES
│  POST   /api/ponentes/register      Crear perfil ponente
│  POST   /api/ponentes/{id}/materiales  Subir material (multipart)
│  GET    /api/ponentes/{id}/inscritos/{eventoId}  Listar inscritos
│
├─ INSCRIPCIONES
│  GET    /api/inscripciones          Listar (requiere auth)
│  POST   /api/inscripciones/register Inscribirse (ROLE_PARTICIPANTE)
│
└─ CERTIFICADOS
   GET    /api/certificacion/{id}/download  Descargar (ROLE_PARTICIPANTE)
"@ -ForegroundColor White
