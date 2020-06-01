package com.test.brillo.service;

import com.test.brillo.bean.Room;

import java.util.List;

public interface BuildService {
    List<Room> getAllRooms(String type, String building);

    Long bookRoom(String id);

    void deleteBooking(String id);
}
