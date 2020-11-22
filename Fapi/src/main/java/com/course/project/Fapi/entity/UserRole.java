package com.course.project.Fapi.entity;

import lombok.Data;

@Data
public class UserRole {
    private long id;
    private String userRole;

    public String getUserRole() {
        return userRole;
    }

    public long getId() {
        return id;
    }
}
