package com.course.project.Order.services.inplementations;

import com.course.project.Order.model.Room;
import com.course.project.Order.repos.RoomRepository;
import com.course.project.Order.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findRoomById(id);
    }

    @Override
    public List<Room> getAll(int page, int size) {
        return roomRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void deleteById(long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int)roomRepository.count();
    }
}
