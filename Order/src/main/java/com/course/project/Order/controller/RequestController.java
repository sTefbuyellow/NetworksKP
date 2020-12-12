package com.course.project.Order.controller;

import com.course.project.Order.dto.RequestDto;
import com.course.project.Order.services.inplementations.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestServiceImpl requestService;

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


}
