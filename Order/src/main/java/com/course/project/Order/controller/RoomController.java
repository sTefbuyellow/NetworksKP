package com.course.project.Order.controller;

import com.course.project.Order.dto.RoomDto;
import com.course.project.Order.model.Room;
import com.course.project.Order.services.inplementations.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping
    public RoomDto create(@RequestBody RoomDto roomDto){
        return roomService.fromRoomToDto(roomService.create(roomService.fromDtoToRoom(roomDto)));
    }

    @GetMapping("/{id}")
    public RoomDto getById(@PathVariable Long id){
        return roomService.fromRoomToDto(roomService.findById(id));
    }

    @GetMapping("/find-all")
    public List<RoomDto> findAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return roomService.getAll(pageNo,pageSize);
    }


}
