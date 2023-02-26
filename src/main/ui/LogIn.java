package ui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The LogIn class provides methods for logging in and creating accounts.
 * It stores user names and passwords in separate ArrayLists.
 */
public class LogIn {
    ArrayList<String> userNames;
    ArrayList<String> passwords;

    //constructor
    public LogIn() {
        userNames = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Effects: Prompts the user to log in or create a new account. If the user selects "Create Account",
    // prompts the user for a new user ID and password and adds them to the userNames and passwords ArrayLists.
    // Otherwise, prompts the user for an existing user ID and password and verifies them. Returns true when a user
    // has successfully logged in.
    @SuppressWarnings("methodlength")
    public boolean logIn() {
        Scanner sc = new Scanner(System.in);
        userNames.add("k");
        passwords.add("k");
        System.out.println("1 - Login \n2 - Create Account");
        int select;
        select = sc.nextInt();
        boolean loggedIn = false;
        if (select == 2) {
            System.out.print("User ID :: ");
            String userName = sc.next();
            userNames.add(userName);
            System.out.print("Password :: ");
            String password = sc.next();
            this.passwords.add(password);
        }
        while (!loggedIn) {
            System.out.print("Enter User ID :: ");
            String userid = sc.next();
            System.out.print("Enter your password :: ");
            String password = sc.next();
            if (userNames.contains(userid) && this.passwords.get(userNames.indexOf(userid)).equals(password)) {
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        return true;
    }
}
