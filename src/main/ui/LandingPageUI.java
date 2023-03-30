package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 The LandingPageUI class is a JPanel that displays the landing page of the Go-Karting Booking System GUI.
 It includes buttons for signing in or creating a new account, and displays a background image of a go-karting track.
 When the user clicks on the "sign in" button, the LandingPageUI object sets its visibility to false and calls the
 logIn() method of a User object. When the user clicks on the "create a new account" button, the LandingPageUI object
 sets its visibility to false and calls the createAccount() method of a User object.
 */

public class LandingPageUI extends JPanel implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton signup;
    private static JButton signin;
    private static ImageIcon imageIcon;

    // Constructor
    public void landingPage() {
        frame = new JFrame();
        frame.setSize(1000, 667);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Go-Karting Booking System");
        panel = new JPanel(new GridLayout(0, 1)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                imageIcon = new ImageIcon("/Users/krish/IdeaProjects/project_w0a4z/GoKartingPhoto.jpeg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        frame.add(panel);
        panel.setLayout(null);
        signIn();
        createAccount();
        frame.setVisible(true);
    }

    // MODIFIES: JButton signin,JPanel panel
    // EFFECTS: Creates a JButton object with the label "Sign in"
    //Sets the bounds of the JButton object
    //Adds the JButton object to the JPanel object
    //Adds an ActionListener to the JButton object to listen for click events
    private void signIn() {
        signin = new JButton("Sign in");
        signin.setBounds(460, 550, 80, 25);
        panel.add(signin);
        signin.addActionListener(new LandingPageUI());
    }

    // MODIFIES: JButton signup,JPanel panel
    // EFFECTS: Creates a JButton object with the label "Create a new account"
    //Sets the bounds of the JButton object
    //Adds the JButton object to the JPanel object
    //Adds an ActionListener to the JButton object to listen for click events
    private void createAccount() {
        signup = new JButton("Create a new account");
        signup.setBounds(350, 580, 300, 25);
        panel.add(signup);
        signup.addActionListener(new LandingPageUI());
    }

    // MODIFIES: JFrame frame
    // EFFECTS: Creates a User object
    // If the source of the ActionEvent is the "signin" button,
    // sets the visibility of the JFrame object to false and calls the logIn() method of the User object
    // If the source of the ActionEvent is the "signup" button,
    // sets the visibility of the JFrame object to false and calls the createAccount() method of the User object
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
