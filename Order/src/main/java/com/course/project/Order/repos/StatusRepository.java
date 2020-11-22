package com.course.project.Order.repos;

import com.course.project.Order.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findStatusById(Long id);
}
