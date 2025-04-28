package uts.isd.model;

import java.io.Serializable;

public class Album implements Serializable {
    private int id;
    private String artist;
    private String title;

    public Album() {

    }

    public Album(int id, String artist, String title) {
        this.id = id;
        this.artist = artist;
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
