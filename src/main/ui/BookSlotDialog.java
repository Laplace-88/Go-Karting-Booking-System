package ui;

import model.TimeSlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Time;

public class BookSlotDialog extends JDialog {
    private JPanel contentPane;

    private MainMenu mainMenu;
    private TimeSlot timeSlot;
    private JTextField racerName;

    public BookSlotDialog(JFrame parent, MainMenu mainMenu, TimeSlot timeSlot, Component parentComponent) {
        super(parent, "View Slots", true);
        this.mainMenu = mainMenu;
        setLayout(new GridLayout(2, 2));
        add(new JLabel("Racer Name"));
        racerName = new JTextField(20);
        add(racerName);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener((ActionEvent e) -> {
            String racerNameS = racerName.getText();
            timeSlot.bookSlot(racerNameS);
            dispose();
            parent.setVisible(true);
        });
        add(saveButton);
        pack();
        setLocationRelativeTo(parentComponent);
    }
}


