package com.course.project.Fapi.service.interfaces;

import com.course.project.Fapi.entity.Status;

import java.util.List;

public interface StatusService {
    Status create (Status status);
    Status findById(long id);
    List<Status> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
}
