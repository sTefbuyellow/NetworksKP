package com.course.project.Order.controller;

import com.course.project.Order.dto.UserDto;
import com.course.project.Order.model.User;
import com.course.project.Order.services.inplementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
         return userService.fromUserToDto(userService.create(userService.fromDtoToUser(userDto)));
    }

    @GetMapping("/id/{id}")
    public UserDto findById(@PathVariable @RequestBody Long id){
        return userService.fromUserToDto(userService.findById(id));
    }

    @GetMapping("/{name}")
    public UserDto findByName(@PathVariable @RequestBody String name){
        return userService.fromUserToDto(userService.findByName(name));
    }

    @GetMapping("/email/{email}")
    public UserDto findByEmail(@PathVariable @RequestBody String email){
        return userService.fromUserToDto(userService.findByEmail(email));
    }

}
