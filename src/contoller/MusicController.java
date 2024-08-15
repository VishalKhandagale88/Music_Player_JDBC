package contoller;

import model.User;
import service.MusicService;

import java.sql.SQLException;
import java.util.Scanner;

public class MusicController {
    private MusicService musicService = new MusicService();
    private Scanner scanner = new Scanner(System.in);

    public void start(){
        while (true){
            System.out.println("1 . Register");
            System.out.println("2 . Login");
            System.out.println("3 . exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 :
                     register();
                    break;
                case 2 :
                    login();
                    break;
                case 3 :
                    System.exit(0);
                    break;
            }
        }
    }
    private void register(){
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();

        User user = new User(4,name,password,email);
        try {
            musicService.addUser(user);
            System.out.println("User registered");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void login(){
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        // validate user
        try {
            if (musicService.validateUser(name,password)){
                System.out.println("Logged in .......");
            }else {
                System.out.println("Invalid credentials");
            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
