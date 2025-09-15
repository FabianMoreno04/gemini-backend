package com.gemini.gemini_backend.dto;

public class AuthRequest {

    private String username;
    private String password;
    private String personaDni; // opcional al registrar

    public AuthRequest() {
    }

    public AuthRequest(String username, String password, String personaDni) {
        this.username = username;
        this.password = password;
        this.personaDni = personaDni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonaDni() {
        return personaDni;
    }

    public void setPersonaDni(String personaDni) {
        this.personaDni = personaDni;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "username='" + username + '\'' +
                ", personaDni='" + personaDni + '\'' +
                '}';
    }
}
