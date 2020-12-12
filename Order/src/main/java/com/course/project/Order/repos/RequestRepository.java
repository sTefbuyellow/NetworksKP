package com.course.project.Order.repos;

import com.course.project.Order.model.Request;
import com.course.project.Order.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request findRequestById(Long id);
    List<Request> findAllByUserId(User id);
}
