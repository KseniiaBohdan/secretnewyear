package com.secretdedmoroz.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Party {

    private String url;
    private Set<User> players;
    private User owner;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String partyName;

    public Party() {
        players = new HashSet<>();
    }

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

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(final Set<User> players) {
        this.players = players;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(final String partyName) {
        this.partyName = partyName;
    }
}
