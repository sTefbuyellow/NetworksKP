package com.course.project.Fapi.service.implementations;

import com.course.project.Fapi.entity.Room;
import com.course.project.Fapi.propertys.BackendApiProperties;
import com.course.project.Fapi.service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private BackendApiProperties backendApiProperties;

    private final RestTemplate restTemplate;

    public RoomServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    @Override
    public Room create(Room room) {
        return restTemplate.postForObject(backendApiProperties.getRoomUri(), room, Room.class);
    }

    @Override
    public Room findById(long id) {
        return restTemplate.getForObject(backendApiProperties.getRoomUri()+"/"+id, Room.class);
    }

    @Override
    public List<Room> getAll(int page, int size) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(backendApiProperties.getRoomUri()
                + "/find-all?pageNo=" + page + "&pageSize=" + size, Room[].class)));
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(backendApiProperties.getRoomUri() + "/" + id);
    }

    @Override
    public int getSize() {
        return Objects.requireNonNull(restTemplate.getForObject
                (backendApiProperties.getRoomUri()+"/size", Integer.class));
    }
}
