package com.course.project.Order.services.inplementations;

import com.course.project.Order.model.Request;
import com.course.project.Order.model.Status;
import com.course.project.Order.repos.RequestRepository;
import com.course.project.Order.services.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Request create(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request findById(long id) {
        return requestRepository.findRequestById(id);
    }

    @Override
    public List<Request> getAll(int page, int size) {
        return requestRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void deleteById(long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int) requestRepository.count();
    }
}
