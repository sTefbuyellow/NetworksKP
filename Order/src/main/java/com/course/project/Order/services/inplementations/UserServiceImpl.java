package com.course.project.Order.services.inplementations;

import com.course.project.Order.model.User;
import com.course.project.Order.repos.UserRepository;
import com.course.project.Order.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findUserById(id);
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
}
