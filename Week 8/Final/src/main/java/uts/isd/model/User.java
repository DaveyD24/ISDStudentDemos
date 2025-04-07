package uts.isd.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String email;
    private String password;
    private String genre;

    public User() {

    }

    public User(String email, String password, String genre) {
        this.email = email;
        this.password = password;
        this.genre = genre;
    }

    public User(int id, String email, String password, String genre) {
        this(email, password, genre);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", genre=" + genre + '}';
    }
}