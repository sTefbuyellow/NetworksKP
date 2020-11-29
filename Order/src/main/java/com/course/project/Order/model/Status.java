package com.course.project.Order.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "status")
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status_name")
    private String roomStatus;

    @OneToOne(mappedBy = "statusId",cascade = CascadeType.ALL)
    private Room roomId;

    public Status(String roomStatus){
        this.roomStatus = roomStatus;
    }

    public Status() {

    }

    public Long getId() {
        return id;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }
}
