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
}
