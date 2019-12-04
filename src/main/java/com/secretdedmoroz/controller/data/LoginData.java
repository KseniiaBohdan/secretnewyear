package com.secretdedmoroz.controller.data;

public class LoginData {

    private String userName;
    private String email;
    private String partyName;

    public LoginData() {
    }

    public LoginData(final String userName, final String email, final String partyName) {
        this.userName = userName;
        this.email = email;
        this.partyName = partyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(final String partyName) {
        this.partyName = partyName;
    }
}
