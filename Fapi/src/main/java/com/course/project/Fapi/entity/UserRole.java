package com.course.project.Fapi.entity;

import lombok.Data;

@Data
public class UserRole {
    private String id;
    private String role;

    public String getUserRole() {
        return role;
    }

    public String getId() {
        return id;
    }
}
