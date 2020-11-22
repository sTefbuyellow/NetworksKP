package com.course.project.Fapi.service.interfaces;

import com.course.project.Fapi.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    User create (User user);
    User findById(long id);
    List<User> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
    User findByEmail(String email);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
