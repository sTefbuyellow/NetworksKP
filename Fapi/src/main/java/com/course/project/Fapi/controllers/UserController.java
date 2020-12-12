package com.course.project.Fapi.controllers;

import com.course.project.Fapi.entity.User;
import com.course.project.Fapi.service.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public User get(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/find-all")
    public List<User> findAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return userService.getAll(pageNo,pageSize);
    }
}
