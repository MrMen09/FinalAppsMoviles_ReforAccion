package com.example.finalappsmoviles_reforaccion;

public class User {

    private String userName;
    private String email;
    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean validatePassword(String confirmPassword) {
        return password.equals(confirmPassword);
    }
}