package com.course.project.Order.repos;

import com.course.project.Order.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleById(Long id);
}
