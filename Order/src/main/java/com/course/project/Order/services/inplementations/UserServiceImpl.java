package com.course.project.Order.services.inplementations;

import com.course.project.Order.dto.UserDto;
import com.course.project.Order.model.User;
import com.course.project.Order.model.UserRole;
import com.course.project.Order.repos.UserRepository;
import com.course.project.Order.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getAll(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int) userRepository.count();
    }

    public User fromDtoToUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSecondName(userDto.getSecondName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        UserRole userRole = new UserRole();
        userRoleService.create(userRole);

        user.setRoleId(userRole);
        return user;
    }

    public UserDto fromUserToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSecondName(user.getSecondName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRoleId(Long.toString(user.getRoleId().getId()));
        return userDto;
    }
}
