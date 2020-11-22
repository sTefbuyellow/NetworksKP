package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.entity.UserRole;
import com.course.project.Fapi.propertys.BackendApiProperties;
import com.course.project.Fapi.service.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public UserRoleServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public UserRole create(UserRole userRole) {
        return restTemplate.postForObject(backendApiProperties.getUserRoleUri(),userRole, UserRole.class);
    }

    @Override
    public UserRole findById(long id) {
        return restTemplate.getForObject(backendApiProperties.getUserRoleUri()+"/"+id, UserRole.class);
    }

    @Override
    public List<UserRole> getAll(int page, int size) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getUserRoleUri()
                + "/find-all/?pageNo=" + page + "&pageSize=" + size, UserRole[].class)));
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(backendApiProperties.getUserRoleUri() + "/" + id);
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(restTemplate.getForObject
                (backendApiProperties.getUserRoleUri()+"/size", Integer.class));
    }
}
