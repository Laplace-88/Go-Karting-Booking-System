package model;

import java.util.ArrayList;

/**
 The LoginData class represents a data structure for storing user login information.
 It contains two ArrayLists for storing usernames and passwords.
 */
public class LoginData {
    private ArrayList<String> userNames;
    private ArrayList<String> passwords;

    // Constructor
    public LoginData(ArrayList<String> userNames, ArrayList<String> passwords) {
        this.userNames = userNames;
        this.passwords = passwords;
    }

    public ArrayList<String> getUserNames() {
        return userNames;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }
}

