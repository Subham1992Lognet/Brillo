package com.test.brillo.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private int floorNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    private Building building;
    @OneToMany(mappedBy = "floor",cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
