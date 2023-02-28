package ui;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The LogIn class provides methods for logging in and creating accounts.
 * It stores usernames and passwords in separate ArrayLists.
 */
public class LogIn {
    ArrayList<String> userNames;
    ArrayList<String> passwords;

    // Constructor
    public LogIn() {
        userNames = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    // MODIFIES: loginData.json
    // EFFECTS: This method exports the userNames and passwords ArrayLists to the loginData.json file
    public void exportDataToJson() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < userNames.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", userNames.get(i));
            jsonObject.put("password", passwords.get(i));
            jsonArray.put(jsonObject);
        }
        try (FileWriter fileWriter = new FileWriter("loginData.json")) {
            fileWriter.write(jsonArray.toString(2));
            System.out.println("Logging you in...");
        } catch (IOException e) {
            System.out.println("Error exporting data to loginData.json");
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: Effects: Prompts the user to log in or create a new account. If the user selects "Create Account",
    // prompts the user for a new user ID and password and adds them to the userNames and passwords ArrayLists.
    // Otherwise, prompts the user for an existing user ID and password and verifies them. Returns true when a user
    // has successfully logged in.
    @SuppressWarnings("methodlength")
    public boolean logIn() {
        Scanner sc = new Scanner(System.in);
        try (FileReader fileReader = new FileReader("loginData.json")) {
            StringBuilder jsonString = new StringBuilder();
            int c;
            while ((c = fileReader.read()) != -1) {
                jsonString.append((char) c);
            }
            JSONArray jsonArray = new JSONArray(jsonString.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                userNames.add(jsonObject.getString("username"));
                passwords.add(jsonObject.getString("password"));
            }
        } catch (IOException e) {
            System.out.println("Error reading data from loginData.json");
            e.printStackTrace();
        }
        System.out.println("1 - Login \n2 - Create Account");
        int select;
        select = sc.nextInt();
        boolean loggedIn = false;
        if (select == 2) {
            System.out.println("----Create Account---");
            System.out.print("Email ID :: ");
            String userName = sc.next();
            userNames.add(userName);
            System.out.print("Password :: ");
            String password = sc.next();
            this.passwords.add(password);
        }
        while (!loggedIn) {
            System.out.println("--------Login-------");
            System.out.print("Email ID :: ");
            String userid = sc.next();
            System.out.print("Password :: ");
            String password = sc.next();
            if (userNames.contains(userid) && this.passwords.get(userNames.indexOf(userid)).equals(password)) {
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        exportDataToJson();
        return true;
    }
}
