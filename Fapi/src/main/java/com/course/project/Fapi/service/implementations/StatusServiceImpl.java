package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.entity.Status;
import com.course.project.Fapi.propertys.BackendApiProperties;
import com.course.project.Fapi.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public StatusServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Status create(Status status) {
        return restTemplate.postForObject(backendApiProperties.getStatusUri(),status, Status.class);
    }

    @Override
    public Status findById(long id) {
        return restTemplate.getForObject(backendApiProperties.getStatusUri()+"/"+id, Status.class);
    }

    @Override
    public List<Status> getAll(int page, int size) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getStatusUri()
                + "/find-all/?pageNo=" + page + "&pageSize=" + size, Status[].class)));
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(backendApiProperties.getStatusUri() + "/" + id);
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(restTemplate.getForObject
                (backendApiProperties.getStatusUri()+"/size", Integer.class));
    }
}
