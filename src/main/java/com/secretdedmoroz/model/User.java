package com.secretdedmoroz.model;

public class User {

    private String email;
    private String name;
    private boolean isPlayer;

    public User(final String email, final String name) {
        this.email = email;
        this.name = name;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(final boolean player) {
        isPlayer = player;
    }
}
