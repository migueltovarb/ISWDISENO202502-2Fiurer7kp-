package com.tuempresa.talleres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tuempresa.talleres.dto.LoginRequest;
import com.tuempresa.talleres.dto.LoginResponse;
import com.tuempresa.talleres.dto.RegisterRequest;
import com.tuempresa.talleres.model.Usuario;
import com.tuempresa.talleres.security.JwtTokenProvider;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UsuarioService usuarioService;

    public LoginResponse authenticate(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);

            return new LoginResponse(jwt, "Login exitoso", true);

        } catch (Exception e) {
            return new LoginResponse(null, "Credenciales inválidas", false);
        }
    }

    public LoginResponse register(RegisterRequest registerRequest) {
        try {
            if (usuarioService.existsByEmail(registerRequest.getEmail())) {
                return new LoginResponse(null, "El email ya está registrado", false);
            }

            Usuario usuario = new Usuario();
            usuario.setNombre(registerRequest.getNombre());
            usuario.setApellido(registerRequest.getApellido());
            usuario.setEmail(registerRequest.getEmail());
            usuario.setPassword(registerRequest.getPassword());
            usuario.setRol("USER");

            usuarioService.save(usuario);

            // Autenticar automáticamente después del registro
            LoginRequest loginRequest = new LoginRequest(registerRequest.getEmail(), registerRequest.getPassword());
            return authenticate(loginRequest);

        } catch (RuntimeException e) {
            return new LoginResponse(null, "Error en registro: " + e.getMessage(), false);
        }
    }

    public void logout(String token) {
        // En una implementación real, podrías invalidar el token
        SecurityContextHolder.clearContext();
    }
}