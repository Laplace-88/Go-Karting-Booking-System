package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    public static boolean logIn() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> userID = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
        System.out.println("1 - Login \n2 - Create Account");
        int select;
        select = sc.nextInt();
        Boolean loggedIn = false;
        if (select == 1) {
            while (!loggedIn) {
                System.out.println("Enter User ID :: ");
                String userid = sc.nextLine();
                System.out.print("Enter your password :: ");
                String password = sc.nextLine();
                if (userID.contains(userid) && pass.get(userID.indexOf(userid)).equals(password)) {
                    loggedIn = true;
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            }
            return loggedIn;
        } else {
            System.out.print("User ID ::");
            String ui = sc.next();
            userID.add(ui);
            System.out.print("Password ::");
            String password = sc.next();
            pass.add(password);
        }
        return true;
    }
}
