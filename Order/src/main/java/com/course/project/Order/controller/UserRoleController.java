package com.course.project.Order.controller;

import com.course.project.Order.dto.RoomDto;
import com.course.project.Order.dto.UserRoleDto;
import com.course.project.Order.model.UserRole;
import com.course.project.Order.services.inplementations.RoomServiceImpl;
import com.course.project.Order.services.inplementations.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;


    @GetMapping("/{id}")
    public UserRoleDto getById(@PathVariable Long id){
        return userRoleService.fromRoleToDto(userRoleService.findById(id));
    }


}
