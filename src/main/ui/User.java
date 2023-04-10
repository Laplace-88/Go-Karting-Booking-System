package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;

/**
 The User class provides methods for logging in and creating accounts.
 It stores usernames and passwords in separate ArrayLists.
 */
public class User extends JFrame implements ActionListener {
    ArrayList<String> userNames;
    ArrayList<String> passwords;
    protected static JFrame frame;
    protected static JPanel panel;
    private static JLabel emailLabel;
    private static JTextField emailText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton logInButton;
    private static JButton signUpButton;
    private static JButton backButton;

    // Constructor
    @SuppressWarnings("methodlength")
    public User() {
        userNames = new ArrayList<>();
        passwords = new ArrayList<>();
        frame = new JFrame();
        frame.setSize(500, 500);
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        emailLabel = new JLabel("Email ID");
        emailText = new JTextField();
        passwordLabel = new JLabel("Password");
        emailLabel.setBounds(100, 180, 80, 25);
        panel.add(emailLabel);
        emailText.setBounds(200, 180, 165, 25);
        panel.add(emailText);
        passwordLabel.setBounds(100, 230, 80, 25);
        panel.add(passwordLabel);
        passwordText = new JPasswordField();
        passwordText.setBounds(200, 230, 165, 25);
        panel.add(passwordText);
        logInButton = new JButton("Log In");
        signUpButton = new JButton("Sign Up");
        logInButton.setBounds(190, 280, 80, 25);
        signUpButton.setBounds(190, 280, 80, 25);
        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 25);
        panel.add(backButton);
        backButton.addActionListener(this);
        importDataFromJson();
        frame.setVisible(true);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // REQUIRES: loginData.json file exists
    // MODIFIES: this
    // EFFECTS: Imports the userNames and passwords ArrayLists from the loginData.json file
    public void importDataFromJson() {
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
    }

    // MODIFIES: this
    // EFFECTS: Prompts the user to log in or create a new account. If the user selects "Create Account",
    // prompts the user for a new user ID and password and adds them to the userNames and passwords ArrayLists.
    // Otherwise, prompts the user for an existing user ID and password and verifies them. Returns true when a user
    // has successfully logged in.
    public void logIn() {
        frame.setTitle("Go-Karting Booking - Sign In");
        panel.add(logInButton);
        logInButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Prompts the user to create a new account. Prompts the user for a new user ID and password and adds them
    // to the userNames and passwords ArrayLists.
    public void createAccount() {
        frame.setTitle("Go-Karting Booking - Create Account");
        panel.add(signUpButton);
        signUpButton.addActionListener(this);
    }

    public void popup(String message, String title) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        final JDialog dialog = pane.createDialog(null, title);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Timer timer = new Timer(3000, evt -> dialog.dispose());
        timer.start(); // Set a timer to automatically close the popup after 3 seconds
        dialog.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: Handles button clicks. If the "Back" button is clicked, closes the User window and returns to the
    // landing page. If the "Log In" button is clicked, verifies the email and password entered and opens the
    // main menu if the login is successful. If the "Sign Up" button is clicked, adds a new username and password
    // to the ArrayLists and exports them to the loginData.json file.
    @SuppressWarnings("methodlength")
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.setVisible(false);
            LandingPageUI launch = new LandingPageUI();
            launch.landingPage();
        } else if (e.getSource() == logInButton) {
            if (userNames.contains(emailText.getText()) && passwords.contains(passwordText.getText())) {
                String message = "Login Successful!";
                popup(message, "Success");
                MainMenu mainMenu = new MainMenu();
                frame.setVisible(false);
                mainMenu.launchManageBooking();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect email/password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == signUpButton) {
            popup("Account Created", "Success");
            userNames.add(emailText.getText());
            passwords.add(passwordText.getText());
            exportDataToJson();
        }
    }
}
