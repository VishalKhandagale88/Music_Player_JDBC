package model;

import java.util.Objects;

public class Song {
    private int songId;
    private String title;
    private String artist;
    private String path;

    public Song(int songId, String title, String artist, String path) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.path = path;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(path, song.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, title, artist, path);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
