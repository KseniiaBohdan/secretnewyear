package com.secretdedmoroz.controller.data;

import com.secretdedmoroz.model.User;

public class Session {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }
}
