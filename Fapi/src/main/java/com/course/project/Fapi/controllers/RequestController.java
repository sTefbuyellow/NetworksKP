package com.course.project.Fapi.controllers;

import com.course.project.Fapi.entity.Request;
import com.course.project.Fapi.entity.Room;
import com.course.project.Fapi.service.implementations.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestServiceImpl requestService;

    @PostMapping
    public ResponseEntity create(@RequestBody Request request){
        requestService.create(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Request get(@PathVariable Long id){
        return requestService.findById(id);
    }

    @GetMapping("/find-all")
    public List<Request> findAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return requestService.getAll(pageNo,pageSize);
    }

    @GetMapping("/find-all/{id}")
    public List<Request> findAll(@PathVariable Long id){
        return requestService.getAllById(id);
    }

    @PostMapping("/refresh/{id}")
    public Request refresh(@RequestBody Room room, @PathVariable Long id){
        return requestService.refreshRequest(room, id);
    }
}
