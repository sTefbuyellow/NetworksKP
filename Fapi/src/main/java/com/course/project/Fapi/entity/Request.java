package com.course.project.Fapi.entity;

public class Request {
    private String id;
    private String describing;
    private String roomId;
    private String userId;

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
