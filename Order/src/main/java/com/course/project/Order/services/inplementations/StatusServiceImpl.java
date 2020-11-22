package com.course.project.Order.services.inplementations;

import com.course.project.Order.model.Status;
import com.course.project.Order.repos.StatusRepository;
import com.course.project.Order.services.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status create(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status findById(long id) {
        return statusRepository.findStatusById(id);
    }

    @Override
    public List<Status> getAll(int page, int size) {
        return statusRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void deleteById(long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int) statusRepository.count();
    }
}
