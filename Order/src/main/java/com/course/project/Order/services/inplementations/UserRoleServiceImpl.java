package com.course.project.Order.services.inplementations;

import com.course.project.Order.model.UserRole;
import com.course.project.Order.repos.UserRoleRepository;
import com.course.project.Order.services.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole findById(long id) {
        return userRoleRepository.findUserRoleById(id);
    }

    @Override
    public List<UserRole> getAll(int page, int size) {
        return userRoleRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void deleteById(long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public int getSize() {
        return (int) userRoleRepository.count();
    }
}
