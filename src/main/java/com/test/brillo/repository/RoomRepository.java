package com.test.brillo.repository;


import com.test.brillo.bean.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoomRepository extends JpaRepository<Room,Long> {
}
