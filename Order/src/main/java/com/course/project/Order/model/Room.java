package com.course.project.Order.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "beds")
    private String beds;

    @Column(name = "area")
    private Long area;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status statusId;

    @OneToOne(mappedBy = "roomId",cascade = CascadeType.ALL)
    private Request request;
}
