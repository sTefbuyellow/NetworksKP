package com.course.project.Fapi.service.interfaces;

import com.course.project.Fapi.entity.Room;

import java.util.List;

public interface RoomService {
    Room create (Room room);
    Room findById(long id);
    List<Room> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
}
