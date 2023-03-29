package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPageUI extends JFrame implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel welcomeLabel;
    private static JButton signup;
    private static JButton signin;

    public void landingPage() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Go-Karting Booking System");
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        welcome();
        signIn();
        createAccount();
        frame.setVisible(true);
    }

    public static void welcome() {
        welcomeLabel = new JLabel("Welcome to Go-Karting Booking System");
        welcomeLabel.setBounds(120, 30, 300, 25);
        panel.add(welcomeLabel);
    }

    private void signIn() {
        signin = new JButton("Sign in");
        signin.setBounds(200, 190, 80, 25);
        panel.add(signin);
        signin.addActionListener(new LandingPageUI());
    }

    private void createAccount() {
        signup = new JButton("Create a new account");
        signup.setBounds(100, 220, 300, 25);
        panel.add(signup);
        signup.addActionListener(new LandingPageUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User account = new User();
        if (e.getSource() == signin) {
            frame.setVisible(false);
            account.logIn();
        } else {
            frame.setVisible(false);
            account.createAccount();
        }
    }
}
