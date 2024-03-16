package com.ontariotechu.sofe3980U;

public class User {
    private String username;
    private String password;
    private Preferences preferences;

    // Constructor with all fields
    public User(String username, String password, Preferences preferences) {
        this.username = username;
        this.password = password;
        this.preferences = preferences;
    }

    // Getters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Preferences getPreferences() {
        return this.preferences;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
