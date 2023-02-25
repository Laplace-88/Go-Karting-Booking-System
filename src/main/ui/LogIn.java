package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    @SuppressWarnings("methodlength")
    public static boolean logIn() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> userID = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
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
