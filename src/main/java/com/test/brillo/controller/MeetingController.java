package com.test.brillo.controller;



import com.test.brillo.bean.Room;
import com.test.brillo.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {

    @Autowired
    private BuildService buildService;

    @GetMapping("/rooms/{type}/{building}")
    public List<Room> getAllRooms(@PathVariable("type") String type, @PathVariable("building") String building){
        return buildService.getAllRooms(type,building);
    }

    @PostMapping("/bookRoom/{id}")
    public String bookRoom(@PathVariable("id") String id){
        return "Booking Ref id " + buildService.bookRoom(id);
    }
    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBooking(@PathVariable("id") String id){
        buildService.deleteBooking(id);
    }


}
