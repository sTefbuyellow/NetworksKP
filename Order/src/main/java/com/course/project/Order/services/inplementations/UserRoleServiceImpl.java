package com.course.project.Order.services.inplementations;

import com.course.project.Order.dto.UserRoleDto;
import com.course.project.Order.model.UserRole;
import com.course.project.Order.repos.UserRoleRepository;
import com.course.project.Order.services.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public UserRoleDto fromRoleToDto(UserRole userRole) {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setId(userRole.getId().toString());
        userRoleDto.setRole(userRole.getRole());
        return userRoleDto;
    }
}
