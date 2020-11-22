package com.course.project.Order.services.interfaces;

import com.course.project.Order.model.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole create (UserRole userRole);
    UserRole findById(long id);
    List<UserRole> getAll(int page, int size);
    void deleteById(long id);
    int getSize();
}
