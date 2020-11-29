package com.course.project.Order.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user_role")
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "roleId",cascade = CascadeType.ALL)
    protected User user;

    public UserRole(){
        role = "ROLE_USER";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
