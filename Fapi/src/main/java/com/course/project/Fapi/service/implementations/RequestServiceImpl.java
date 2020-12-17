package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.entity.Request;
import com.course.project.Fapi.entity.Room;
import com.course.project.Fapi.propertys.BackendApiProperties;
import com.course.project.Fapi.service.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public RequestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Request create(Request request) {
        return restTemplate.postForObject(backendApiProperties.getRequestUri(),request, Request.class);
    }

    @Override
    public Request findById(long id) {
        return restTemplate.getForObject(backendApiProperties.getRequestUri()+"/"+id, Request.class);
    }

    @Override
    public List<Request> getAll(int page, int size) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getRequestUri()
                + "/find-all/?pageNo=" + page + "&pageSize=" + size, Request[].class)));
    }

    public List<Request> getAllById(Long id) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getRequestUri()
                + "/find-all/" + id, Request[].class)));
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(backendApiProperties.getRequestUri() + "/" + id);
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(restTemplate.getForObject
                (backendApiProperties.getRequestUri()+"/size", Integer.class));
    }

    public Request refreshRequest(Room room, Long id) {
        return restTemplate.postForObject(backendApiProperties.getRequestUri()+"/refresh/"+id, room, Request.class);
    }
}
