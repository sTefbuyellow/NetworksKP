package com.course.project.Fapi.entity;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private String authenticationToken;
    private String username;
    private String role;

    public AuthenticationResponse(String authenticationToken, String username, String role) {
        this.authenticationToken = authenticationToken;
        this.username = username;
        this.role = role;
    }
}
