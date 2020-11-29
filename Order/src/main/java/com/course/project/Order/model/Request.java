package com.course.project.Order.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "request")
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "room_id", referencedColumnName = "id")
    private Room roomId;
}
