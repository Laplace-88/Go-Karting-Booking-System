package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoginDataTest {

    private ArrayList<String> userNames;
    private ArrayList<String> passwords;

    @BeforeEach
    public void setup() {
        userNames = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    @Test
    public void testGetUserNames() {
        userNames.add("Alice");
        userNames.add("Bob");
        userNames.add("Charlie");
        LoginData loginData = new LoginData(userNames, new ArrayList<>());
        assertEquals(userNames, loginData.getUserNames());
    }

    @Test
    public void testGetPasswords() {
        passwords.add("password123");
        passwords.add("secret");
        LoginData loginData = new LoginData(new ArrayList<>(), passwords);
        assertEquals(passwords, loginData.getPasswords());
    }
}

