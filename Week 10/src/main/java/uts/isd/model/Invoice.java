package uts.isd.model;

public class Invoice {
    private int id;
    private User user;
    private Album album;

    public Invoice() {

    }

    public Invoice(int id, User user, Album album) {
        this.id = id;
        this.user = user;
        this.album = album;
    }

    public Invoice (User user, Album album) {
        this.user = user;
        this.album = album;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
}
