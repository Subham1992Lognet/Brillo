package com.test.brillo.repository;

import com.test.brillo.bean.Building;
import com.test.brillo.bean.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {
    @Query("SELECT rm.id, rm.roomName, rm.roomStatus, rm.roomType FROM Building bd inner join bd.floors flr inner join flr.rooms rm " +
            "WHERE rm.roomType = ?1 and bd.buildingName = ?2")
    List<Object[]> getAllRooms(String type, String building);

}
