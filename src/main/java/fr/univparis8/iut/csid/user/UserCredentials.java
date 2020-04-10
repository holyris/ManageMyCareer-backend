package fr.univparis8.iut.csid.user;

import org.springframework.beans.factory.annotation.Autowired;

public class UserCredentials {


    @Autowired
    private String username;

    @Autowired
    private String password;

    public UserCredentials(){
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
}
