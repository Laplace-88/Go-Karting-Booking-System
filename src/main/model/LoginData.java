package model;

import java.util.ArrayList;

public class LoginData {
    private ArrayList<String> userNames;
    private ArrayList<String> passwords;

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

