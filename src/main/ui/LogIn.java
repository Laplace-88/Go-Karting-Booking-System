package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    ArrayList<String> userID;
    ArrayList<String> pass;

    public LogIn() {
        userID = new ArrayList<>();
        pass = new ArrayList<>();
    }

    @SuppressWarnings("methodlength")
    public boolean logIn() {
        Scanner sc = new Scanner(System.in);
        userID.add("k");
        pass.add("k");
        System.out.println("1 - Login \n2 - Create Account");
        int select;
        select = sc.nextInt();
        boolean loggedIn = false;
        if (select == 2) {
            System.out.print("User ID :: ");
            String ui = sc.next();
            userID.add(ui);
            System.out.print("Password :: ");
            String password = sc.next();
            pass.add(password);
        }
        while (!loggedIn) {
            System.out.print("Enter User ID :: ");
            String userid = sc.next();
            System.out.print("Enter your password :: ");
            String password = sc.next();
            if (userID.contains(userid) && pass.get(userID.indexOf(userid)).equals(password)) {
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        return true;
    }
}
