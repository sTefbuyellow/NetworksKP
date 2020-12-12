package com.course.project.Fapi.controllers;

import com.course.project.Fapi.entity.Room;
import com.course.project.Fapi.entity.UserRole;
import com.course.project.Fapi.service.implementations.RoomServiceImpl;
import com.course.project.Fapi.service.implementations.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserRole userRole) {
        userRoleService.create(userRole);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public UserRole get(@PathVariable Long id) {
        return userRoleService.findById(id);
    }

}
