package com.course.project.Fapi.service.interfaces;

import com.course.project.Fapi.entity.Request;

import java.util.List;

public interface RequestService {
    Request create (Request request);
    Request findById(long id);
    List<Request> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
}
