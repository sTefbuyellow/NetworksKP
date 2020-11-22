package com.course.project.Order.repos;


import com.course.project.Order.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    User findUserByName(String name);
    User findUserById(Long id);
}
