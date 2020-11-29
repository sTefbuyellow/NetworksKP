package com.course.project.Fapi.controllers;

import com.course.project.Fapi.entity.Room;
import com.course.project.Fapi.service.implementations.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping
    public ResponseEntity create(@RequestBody Room room){
         roomService.create(room);
         return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Room get(@PathVariable Long id){
        return roomService.findById(id);
    }

    @GetMapping("/find-all")
    public List<Room> findAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return roomService.getAll(pageNo,pageSize);
    }
}
