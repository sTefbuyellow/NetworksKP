package com.course.project.Order.services.interfaces;

import com.course.project.Order.dto.RoomDto;
import com.course.project.Order.model.Room;
import com.course.project.Order.model.User;

import java.util.List;

public interface RoomService {
    Room create (Room room);
    Room findById(long id);
    List<RoomDto> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
    Room fromDtoToRoom(RoomDto roomDto);
    RoomDto fromRoomToDto(Room room);
}
