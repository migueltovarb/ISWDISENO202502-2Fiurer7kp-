package com.tuempresa.talleres.dto;

public class LoginResponse {
    private String token;
    private String message;
    private boolean success;

    // Constructor vacío
    public LoginResponse() {
    }

    // Constructor con parámetros
    public LoginResponse(String token, String message, boolean success) {
        this.token = token;
        this.message = message;
        this.success = success;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}