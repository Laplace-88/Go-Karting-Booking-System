package ui;

import model.TimeSlot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;

/**
 * Constructs a BookingSystem object.
 * It initializes the timeSlots list with all available time slots for the day.
 */
public class BookingManagement extends JFrame implements ActionListener {
    private final List<TimeSlot> timeSlots;

    private final JFrame frame;
    private final JPanel panel;

    // Constructor
    public BookingManagement() {
        this.timeSlots = new ArrayList<>();
        LocalTime time = LocalTime.of(12, 0);
        for (int i = 0; i < 24; i++) {
            TimeSlot slot = new TimeSlot(time, 10);
            timeSlots.add(slot);
            time = time.plusMinutes(30);
        }
        frame = new JFrame();
        panel = new JPanel(new GridLayout(0, 2));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2, 24));
        frame.setTitle("Go-Karting Booking System");
    }

    // MODIFIES: this, selectedSlot
    // EFFECTS: Prompts the user to enter the name of the racer who wants to book a time slot.
    //- Lists the available time slots and prompts the user to select a time slot to book.
    //- If the selected time slot is available, the slot is booked for the racer and their name is added to the list
    // of booked racers for the selected slot. The selected slot is also added to the list of booked time slots.
    //- If the selected time slot is already booked, a message is displayed informing the user that the slot is already
    // full.
    public void bookSlot() {
        frame.add(panel);
        JLabel racerName = new JLabel("Racer name");
        JTextField racerText = new JTextField();
        racerName.setBounds(100, 180, 80, 25);
        panel.add(racerName);
        racerText.setBounds(200, 180, 165, 25);
        panel.add(racerText);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available time slots:");
        int slotIndex = 1;
        for (TimeSlot slot : timeSlots) {
            if (slot.isAvailable()) {
                System.out.println(slotIndex + ". " + slot.toString());
                System.out.println("Racer Slots Remaining :: " + slot.getRemainingRacerSlots());
            }
            slotIndex++;
        }
        System.out.print("Enter the slot number you want to book: ");
        int selectedSlotIndex = scanner.nextInt();
        TimeSlot selectedSlot = timeSlots.get(selectedSlotIndex - 1);
//        if (selectedSlot.bookSlot(racerText)) {
//            System.out.println("Slot booked successfully! Racer Names: " + selectedSlot.getBookedRacers());
//        } else {
//            System.out.println("Slot is already full. Please select another slot.");
//        }
        frame.setVisible(true);
        saveBookingInfo();
    }

    // MODIFIES: this
    // EFFECTS: - Prompts the user to enter the name of the racer whose booking they want to cancel.
    //- Searches through the list of booked time slots to find a slot that has been booked by the specified racer.
    //- If a slot is found, the racer's name is removed from the list of booked racers for the slot, and a message is
    // displayed informing the user that the booking has been cancelled.
    //- If no slot is found, a message is displayed informing the user that no booking was found for the specified
    // racer.
    public void cancelSlot() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Current Bookings: ");
        for (TimeSlot slot : timeSlots) {
            if (!slot.getBookedRacers().isEmpty()) {
                System.out.println(slot.getStartTime() + " - " + slot.getEndTime() + "\n Racer Name: "
                        + slot.getBookedRacers());
            }
        }
        System.out.print("Enter the name of the racer whose booking you want to cancel: ");
        String racerName = sc.nextLine();
        boolean found = false;
        for (TimeSlot slot : timeSlots) {
            if (slot.getBookedRacers().contains(racerName)) {
                slot.getBookedRacers().remove(racerName);
                found = true;
                System.out.println("Booking cancelled successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("No booking found for racer: " + racerName);
        }
        saveBookingInfo();
    }

    // MODIFIES: Bookings.json
    // EFFECTS: This method exports the start-time, end-time, capacity, booked racers and
    // remaining slots ArrayLists to the Bookings.json file
    private void saveBookingInfo() {
        JSONArray bookings = new JSONArray();
        for (TimeSlot slot : timeSlots) {
            if (!slot.getBookedRacers().isEmpty()) {
                JSONObject booking = new JSONObject();
                booking.put("start_time", slot.getStartTime().toString());
                booking.put("end_time", slot.getEndTime().toString());
                booking.put("capacity", slot.getCapacity());
                booking.put("booked_racers", new JSONArray(slot.getBookedRacers()));
                booking.put("remaining_slots", slot.getRemainingRacerSlots());
                bookings.put(booking);
            }
        }
        try {
            FileWriter file = new FileWriter("Bookings.json");
            file.write(bookings.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving booking information.");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
