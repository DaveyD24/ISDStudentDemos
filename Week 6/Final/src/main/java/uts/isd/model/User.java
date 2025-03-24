package uts.isd.model;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String password;
    private Genre genre;

    public User() {

    }

    public User(String email, String password, Genre genre) {
        this.email = email;
        this.password = password;
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}