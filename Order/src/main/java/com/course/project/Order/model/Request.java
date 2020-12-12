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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "room_id", referencedColumnName = "id")
    private Room roomId;

    @Column(name = "describing")
    private String describing;

    public Long getId() {
        return id;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }
}
