package com.course.project.Order.services.inplementations;

import com.course.project.Order.dto.RequestDto;
import com.course.project.Order.model.Request;
import com.course.project.Order.model.Room;
import com.course.project.Order.model.Status;
import com.course.project.Order.model.User;
import com.course.project.Order.repos.RequestRepository;
import com.course.project.Order.services.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StatusServiceImpl statusService;

    @Autowired
    private RoomServiceImpl roomService;

    @Override
    public Request create(Request request) {
        return requestRepository.save(request);
    }

    public Request refreshRequest(Room room, Long id) {
        Request request = requestRepository.findRequestById(id);
        request.setRoomId(room);
        Status status = statusService.findById(room.getStatusId().getId());
        status.setRoomStatus("Engaged");
        statusService.create(status);
        requestRepository.save(request);
        return request;
    }


    @Override
    public Request findById(long id) {
        return requestRepository.findRequestById(id);
    }

    @Override
    public List<RequestDto> getAll(int page, int size) {
        List<Request> requests = requestRepository.findAll(PageRequest.of(page, size)).getContent();
        return requests.stream().map(this::fromRequestToDto).collect(toList());
    }

    public List<RequestDto> getAllById(Long id) {
        userService.findById(id);
        List<Request> requests = requestRepository.findAllByUserId(userService.findById(id));
        return requests.stream().map(this::fromRequestToDto).collect(toList());
    }

    @Override
    public void deleteById(long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int) requestRepository.count();
    }

    public RequestDto fromRequestToDto(Request request){
        RequestDto requestDto = new RequestDto();
        requestDto.setId(Long.toString(request.getId()));
        requestDto.setDescribing(request.getDescribing());
        if (request.getRoomId() == null)
            requestDto.setRoomId(null);
        else
            requestDto.setRoomId(Long.toString(request.getRoomId().getId()));
        requestDto.setUserId(Long.toString(request.getUserId().getId()));
        return requestDto;
    }

    public Request fromDtoToRequest(RequestDto requestDto) {
        Request request = new Request();
        request.setDescribing(requestDto.getDescribing());
        request.setUserId(userService.findByName(requestDto.getUserId()));
        return request;
    }
}
