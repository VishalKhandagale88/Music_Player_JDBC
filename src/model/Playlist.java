package model;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private int playlistId;
    private String name;
    private User user;
    private List<Song> songs;

    public Playlist(int playlistId, String name, User user, List<Song> songs) {
        this.playlistId = playlistId;
        this.name = name;
        this.user = user;
        this.songs = songs;
    }

    public Playlist(int playlistId, String name, User user) {
        this.playlistId = playlistId;
        this.name = name;
        this.user = user;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && Objects.equals(name, playlist.name) && Objects.equals(user, playlist.user) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, name, user, songs);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", songs=" + songs +
                '}';
    }
}
