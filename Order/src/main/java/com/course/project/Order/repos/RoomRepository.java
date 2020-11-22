package com.course.project.Order.repos;

import com.course.project.Order.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomById(Long id);
}
