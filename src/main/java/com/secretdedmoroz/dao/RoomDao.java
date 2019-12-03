package com.secretdedmoroz.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.secretdedmoroz.model.Room;

@Repository
public class RoomDao {

    private static List<Room> rooms = new ArrayList<>();

    public static List<Room> getRooms() {
        return rooms;
    }

    public static void setRooms(final List<Room> rooms) {
        RoomDao.rooms = rooms;
    }

    public boolean addRoom(Room room) {
        if (!rooms.contains(room)) {
            return rooms.add(room);
        } else {
            return false;
        }
    }

    public Room getRoomByUrl(final String roomUrl) {
        return rooms.stream().filter(r -> r.getUrl().equals(roomUrl)).findFirst().orElse(null);
    }
}
