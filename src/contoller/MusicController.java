package contoller;

import model.Playlist;
import model.Song;
import model.User;
import service.MusicService;
import util.AudioPlayer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MusicController {
    private final MusicService musicService = new MusicService();
    private final Scanner scanner = new Scanner(System.in);
    private User currentUser;

    public void start() {
        while (true) {
            System.out.println("1 . Register");
            System.out.println("2 . Login");
            System.out.println("3 . View all songs");
            System.out.println("4 . Play song");
            System.out.println("5 . exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    viewALlSongs();
                case 4:
                    playSong();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private void register() {
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();

        User user = new User(4, name, password, email);
        try {
            musicService.addUser(user);
            System.out.println("User registered");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void login() {
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        // validate user
        try {
            if (musicService.validateUser(name, password)) {
                System.out.println("Logged in .......");
                // get user id
                currentUser = musicService.getUserByName(name);
                userMenu();
            } else {
                System.out.println("Invalid credentials");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void userMenu() {
        while (true) {
            System.out.println("1. create playlist");
            System.out.println("2. Add songs to playlist");
            System.out.println("Select above options");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createPlaylist();
                    break;
                case 2:
                    getAllPlaylist();
                    break;
                case 3 :
                    // add song to playlist

                    break;
                case 4:

                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    private void addSongToPlayList(){
        System.out.println("Enter playlist id");
        int playListId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Displaying all songs .....");
        viewALlSongs();
        System.out.println("Select a song id");
        int songId = scanner.nextInt();
        scanner.nextLine();
        // insert into playlist_songs table
        try {
            musicService.addSongToPlayList(playListId,songId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("song is added");
    }

    private void getAllPlaylist() {
        try {
            List<Playlist> allPlaylists = musicService.getAllPlaylists(currentUser.getUserId());
            if (allPlaylists.isEmpty()) {
                System.out.println("No play found");
                return;
            }
            System.out.println("All playlists of " + currentUser.getUserName());
            allPlaylists.forEach(playlist -> System.out.println(playlist.getPlaylistId() + "  - " + playlist.getName()));
            addSongToPlayList();
            // to select a playlist
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createPlaylist() {
        System.out.println("Enter playlist name");
        String playlistName = scanner.nextLine();
        System.out.println();
        Playlist userPlaylist = new Playlist(0, playlistName, currentUser);
        try {
            musicService.createPlaylist(userPlaylist);
            System.out.println("Playlist created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewALlSongs() {
        try {
            List<Song> allSongs = musicService.getAllSongs();
            allSongs.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void playSong() {
        viewALlSongs();

        System.out.println("Enter song id from above songs list");
        int songId = scanner.nextInt();
        scanner.nextLine();
        try {
            Song selectedSong = musicService.getAllSongs().stream().filter(song -> song.getSongId() == songId).findFirst().orElse(null);
            if (selectedSong != null) {
                System.out.println("Playing audio");
                AudioPlayer.playAudio(selectedSong.getPath());
            } else {
                System.out.println("Song not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
