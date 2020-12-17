package com.course.project.Order.dto;

import com.course.project.Order.model.Request;

public class RequestDto {
    private String id;
    private String userId;
    private String roomId;
    private String describing;

    public RequestDto(){
        this.roomId = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }
}

