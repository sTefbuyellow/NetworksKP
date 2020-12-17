package com.course.project.Order.services.inplementations;

import com.course.project.Order.dto.RoomDto;
import com.course.project.Order.model.Room;
import com.course.project.Order.model.Status;
import com.course.project.Order.repos.RoomRepository;
import com.course.project.Order.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StatusServiceImpl statusService;

    @Override
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findRoomById(id);
    }


    @Override
    public List<RoomDto> getAll(int page, int size) {
        List<Room> rooms = roomRepository.findAll(PageRequest.of(page, size)).getContent();
        return rooms.stream().map(this::fromRoomToDto).collect(toList());
    }

    @Override
    public void deleteById(long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int)roomRepository.count();
    }

    @Override
    public Room fromDtoToRoom(RoomDto roomDto){
        Room room = new Room();
        room.setArea(Long.parseLong(roomDto.getArea()));
        room.setDescription(roomDto.getDescription());

        Status status = new Status("Processing");
        statusService.create(status);

        room.setStatusId(status);
        return room;
    }



    @Override
    public RoomDto fromRoomToDto(Room room){
        RoomDto roomDto = new RoomDto();
        roomDto.setId(Long.toString(room.getId()));
        roomDto.setArea(Long.toString(room.getArea()));
        roomDto.setDescription(room.getDescription());
        roomDto.setStatusId(room.getStatusId().getRoomStatus());
        return roomDto;
    }
}
