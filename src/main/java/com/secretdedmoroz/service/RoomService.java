package com.secretdedmoroz.service;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.secretdedmoroz.dao.RoomDao;
import com.secretdedmoroz.dao.UserDao;
import com.secretdedmoroz.model.Room;
import com.secretdedmoroz.model.User;

@Service
public class RoomService {

    @Resource
    private RoomDao roomDao;
    @Resource
    private UserDao userDao;

    public boolean createRoom(String ownerEmail, LocalDateTime startDateTime, LocalDateTime endDateTime, String roomName) {
        String url = UUID.randomUUID() + "_" + roomName;
        User owner = userDao.getUserByEmail(ownerEmail);
        Room room = new Room();
        room.setOwner(owner);
        room.setRoomName(roomName);
        room.setStartDateTime(startDateTime);
        room.setEndDateTime(endDateTime);
        room.setUrl(url);
        return roomDao.addRoom(room);
    }

    public String createRoom(String ownerEmail, final String roomName) {
        String url = "localhost:8080/rooms?roomUrl=" + UUID.randomUUID() + "_" + roomName;
        User owner = userDao.getUserByEmail(ownerEmail);
        Room room = new Room();
        room.setOwner(owner);
        room.setRoomName(roomName);
        setDefaultDuration();
        room.setUrl(url);
        roomDao.addRoom(room);
        return url;
    }

    public Room getRoomByUrl(String roomUrl) {
        return roomDao.getRoomByUrl(roomUrl);
    }

    private void setDefaultDuration() {

    }

}
