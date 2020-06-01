package com.test.brillo.service;

import com.test.brillo.bean.Booking;
import com.test.brillo.bean.Room;
import com.test.brillo.repository.BuildingRepository;
import com.test.brillo.repository.MeetingRepository;
import com.test.brillo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildServiceImpl implements BuildService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<Room> getAllRooms(String type, String building) {
        List<Object[]> rooms = buildingRepository.getAllRooms(type,building);
        List<Room> listOfRooms = new ArrayList<>();
        Room room = null;
        for(int i = 0; i< rooms.size();i++){
            room = new Room();
            room.setId((Long) rooms.get(i)[0]);
            room.setRoomName((String) rooms.get(i)[1]);
            room.setRoomStatus((String) rooms.get(i)[2]);
            room.setRoomType((String) rooms.get(i)[3]);
            listOfRooms.add(room);
        }
        return listOfRooms;
    }

    @Override
    public Long bookRoom(String id) {
        Booking booking = new Booking();
        booking.setRoomId(Long.valueOf(id));
        Booking booking1 = meetingRepository.save(booking);
        Optional<Room> roomToUpdate = roomRepository.findById(Long.valueOf(id));
        Room r = roomToUpdate.get();
        r.setRoomStatus("Booked");
        roomRepository.save(r);
        return booking1.getId();
    }

    @Override
    public void deleteBooking(String id) {

        Optional<Booking> bking = meetingRepository.findById(Long.valueOf(id));
        Optional<Room> roomToUpdate = roomRepository.findById(bking.get().getRoomId());
        Room r = roomToUpdate.get();
        r.setRoomStatus("Active");
        roomRepository.save(r);
        meetingRepository.deleteById(Long.valueOf(id));

    }
}
