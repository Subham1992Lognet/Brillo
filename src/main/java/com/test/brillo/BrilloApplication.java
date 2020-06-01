package com.test.brillo;

import com.test.brillo.bean.Building;
import com.test.brillo.bean.Floor;
import com.test.brillo.bean.Room;
import com.test.brillo.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrilloApplication implements CommandLineRunner {
	@Autowired
	private BuildingRepository buildingRepository;

	public static void main(String[] args) {
		SpringApplication.run(BrilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Building building = new Building();
		building.setBuildingName("1A");
		Floor floor = new Floor();
		floor.setFloorNumber(3);
		floor.setBuilding(building);
		Room room = new Room();
		room.setRoomName("Gitobitan");
		room.setRoomType("Eight");
		room.setFloor(floor);
		room.setRoomStatus("Active");

		Room room1 = new Room();
		room1.setRoomName("Ecospace");
		room1.setRoomType("Four");
		room1.setFloor(floor);
		room1.setRoomStatus("Active");




		floor.getRooms().add(room);
		floor.getRooms().add(room1);

		Floor floor1 = new Floor();
		floor1.setFloorNumber(5);
		floor1.setBuilding(building);
		Room room2 = new Room();
		room2.setRoomName("Avengers");
		room2.setRoomType("Eight");
		room2.setFloor(floor1);
		room2.setRoomStatus("Active");

		Room room3 = new Room();
		room3.setRoomName("JusticeLeague");
		room3.setRoomType("Four");
		room3.setFloor(floor1);
		room3.setRoomStatus("Active");

		floor1.getRooms().add(room2);
		floor1.getRooms().add(room3);


		building.getFloors().add(floor);
		building.getFloors().add(floor1);

		buildingRepository.save(building);
	}
}
