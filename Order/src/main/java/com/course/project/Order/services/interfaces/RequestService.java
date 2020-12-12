package com.course.project.Order.services.interfaces;

import com.course.project.Order.dto.RequestDto;
import com.course.project.Order.model.Request;

import java.util.List;

public interface RequestService{
    Request create (Request request);
    Request findById(long id);
    List<RequestDto> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
}
