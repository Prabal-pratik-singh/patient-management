package com.pm.authservice.dto;

public class LoginResponseDTO {
    private final String tokens;

    public LoginResponseDTO(String tokens) {
        this.tokens = tokens;
    }

    public String getTokens() {
        return tokens;
    }
}
