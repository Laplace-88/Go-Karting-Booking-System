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
 * The LogIn class provides methods for logging in and creating accounts.
 * It stores usernames and passwords in separate ArrayLists.
 */
public class User extends JFrame implements ActionListener {
    ArrayList<String> userNames;
    ArrayList<String> passwords;
    private static JFrame frame;
    private static JPanel panel;
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
            System.out.println("Error exporting data to loginData.json");
            e.printStackTrace();
        }
    }

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
    // EFFECTS: Effects: Prompts the user to log in or create a new account. If the user selects "Create Account",
    // prompts the user for a new user ID and password and adds them to the userNames and passwords ArrayLists.
    // Otherwise, prompts the user for an existing user ID and password and verifies them. Returns true when a user
    // has successfully logged in.
    public void logIn() {
        panel.add(logInButton);
        logInButton.addActionListener(this);
    }

    public void createAccount() {
        panel.add(signUpButton);
        signUpButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            LandingPageUI launch = new LandingPageUI();
            launch.landingPage();
        } else if (e.getSource() == logInButton) {
            if (userNames.contains(emailText.getText()) && passwords.contains(passwordText.getText())) {
                System.out.println("Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect email/password", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Incorrect Email/Password");
            }
        } else if (e.getSource() == signUpButton) {
            userNames.add(emailText.getText());
            passwords.add(passwordText.getText());
        }
        exportDataToJson();
    }
}
