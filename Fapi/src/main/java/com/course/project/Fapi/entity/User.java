package com.course.project.Fapi.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String secondName;
    private String email;
    private String password;
    private UserRole roleId;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRoleId() {
        return roleId;
    }
}
