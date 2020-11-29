package com.course.project.Order.services.interfaces;

import com.course.project.Order.model.User;
import java.util.List;


public interface UserService {
    User create (User user);
    User findById(long id);
    User findByName(String name);
    User findByEmail(String name);
    List<User> getAll(int page, int size);
    void deleteById(long id);
    int getSize();

}
