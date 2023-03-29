package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingPage extends JFrame implements ActionListener {

    private final JFrame frame;
    private final JPanel panel;
    BookingManagement bookingManagement;
    private final JButton bookSlot;
    private final JButton cancelBooking;
    private final JButton quit;

    public BookingPage() {
        frame = new JFrame();
        bookingManagement = new BookingManagement();
        panel = new JPanel(new GridLayout(0,1));
        bookSlot = new JButton("Book a Slot");
        cancelBooking = new JButton("Cancel a Booking");
        quit = new JButton("Quit");
    }

    public void launchBookingPage() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Go-Karting Booking System");
        panel.add(bookSlot);
        bookSlot.addActionListener(this);
        panel.add(cancelBooking);
        cancelBooking.addActionListener(this);
        panel.add(quit);
        quit.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookSlot) {
            frame.setVisible(false);
            bookingManagement.bookSlot();
        } else if (e.getSource() == cancelBooking) {
            frame.setVisible(false);
            bookingManagement.cancelSlot();
        } else if (e.getSource() == quit) {
            frame.setVisible(false);
            System.exit(0);
        }
    }
}