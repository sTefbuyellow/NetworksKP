package com.course.project.Order.services.interfaces;

import com.course.project.Order.model.Room;
import com.course.project.Order.model.Status;

import java.util.List;

public interface StatusService {
    Status create (Status status);
    Status findById(long id);
    List<Status> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
}
