package com.course.project.Order.controller;

import com.course.project.Order.dto.RequestDto;
import com.course.project.Order.dto.RoomDto;
import com.course.project.Order.services.inplementations.RequestServiceImpl;
import com.course.project.Order.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestServiceImpl requestService;

    @Autowired
    private RoomService roomService;

    @PostMapping
    public RequestDto create(@RequestBody RequestDto requestDto){
        return requestService.fromRequestToDto(requestService.create(requestService.fromDtoToRequest(requestDto)));
    }

    @GetMapping("/{id}")
    public RequestDto getById(@PathVariable Long id){
        return requestService.fromRequestToDto(requestService.findById(id));
    }

    @GetMapping("/find-all")
    public List<RequestDto> findAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return requestService.getAll(pageNo,pageSize);
    }

    @GetMapping("/find-all/{id}")
    public List<RequestDto> findAllById(@PathVariable Long id){
        return requestService.getAllById(id);
    }

    @PostMapping("/refresh/{id}")
    public RequestDto refreshRequest(@RequestBody RoomDto roomDto, @PathVariable Long id){
        return requestService.fromRequestToDto(requestService.refreshRequest(roomService.findById(id), id));
    }

}
