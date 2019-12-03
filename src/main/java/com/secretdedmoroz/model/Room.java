package com.secretdedmoroz.model;

import java.time.LocalDateTime;
import java.util.Set;

public class Room {

    private String url;
    private Set<User> users;
    private User owner;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String roomName;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(final User owner) {
        this.owner = owner;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(final LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(final LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(final String roomName) {
        this.roomName = roomName;
    }
}
