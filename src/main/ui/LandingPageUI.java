package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPageUI extends JPanel implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton signup;
    private static JButton signin;
    private static ImageIcon imageIcon;

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

    private void signIn() {
        signin = new JButton("Sign in");
        signin.setBounds(460, 550, 80, 25);
        panel.add(signin);
        signin.addActionListener(new LandingPageUI());
    }

    private void createAccount() {
        signup = new JButton("Create a new account");
        signup.setBounds(350, 580, 300, 25);
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
