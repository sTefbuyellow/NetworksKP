package com.course.project.Order.repos;

import com.course.project.Order.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request findRequestById(Long id);
}
