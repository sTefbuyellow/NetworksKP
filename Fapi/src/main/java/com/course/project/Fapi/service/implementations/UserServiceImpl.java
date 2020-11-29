package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.entity.User;
import com.course.project.Fapi.propertys.BackendApiProperties;
import com.course.project.Fapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BackendApiProperties backendApiProperties;


    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public User create(User user) {
        return restTemplate.postForObject(backendApiProperties.getUserUri(), user, User.class);
    }


    @Override
    public User findById(long id) {
        return restTemplate.getForObject(backendApiProperties.getUserUri() + "/" + id, User.class);
    }


    @Override
    public User findByName(String name) {
        return restTemplate.getForObject(backendApiProperties.getUserUri() + "/" + name, User.class);
    }

    @Override
    public User findByEmail(String email) {
        return restTemplate.getForObject(backendApiProperties.getUserUri() + "/email/" + email, User.class);
    }

    //Возможна проблема из-за Objects.requireNonNull
    @Override
    public List<User> getAll(int page, int size) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getUserUri()
                + "/find-all/?pageNo=" + page + "&pageSize=" + size, User[].class)));
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(backendApiProperties.getUserUri() + "/" + id);
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(restTemplate.getForObject
                (backendApiProperties.getUserUri() + "/size", Integer.class));
    }

}
