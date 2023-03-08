package ui;

import model.TimeSlot;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Constructs a BookingSystem object.
 * It initializes the timeSlots list with all available time slots for the day.
 */
public class BookingSystem {
    private final List<TimeSlot> timeSlots;
    private final List<TimeSlot> bookedTimeSlots;

    // Constructor
    public BookingSystem() {
        this.timeSlots = new ArrayList<>();
        LocalTime time = LocalTime.of(12, 0);
        for (int i = 0; i < 24; i++) {
            TimeSlot slot = new TimeSlot(time, 10);
            timeSlots.add(slot);
            time = time.plusMinutes(30);
        }
        this.bookedTimeSlots = new ArrayList<>();
    }

    // MODIFIES: this, selectedSlot
    // EFFECTS: Prompts the user to enter the name of the racer who wants to book a time slot.
    //- Lists the available time slots and prompts the user to select a time slot to book.
    //- If the selected time slot is available, the slot is booked for the racer and their name is added to the list
    // of booked racers for the selected slot. The selected slot is also added to the list of booked time slots.
    //- If the selected time slot is already booked, a message is displayed informing the user that the slot is already
    // full.
    public void bookSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Racer name: ");
        String racerName = scanner.nextLine();
        System.out.println("Available time slots:");
        int slotIndex = 1;
        for (TimeSlot slot : timeSlots) {
            if (slot.isAvailable()) {
                System.out.println(slotIndex + ". " + slot.toString());
            }
            slotIndex++;
        }
        System.out.print("Enter the slot number you want to book: ");
        int selectedSlotIndex = scanner.nextInt();
        TimeSlot selectedSlot = timeSlots.get(selectedSlotIndex - 1);
        if (selectedSlot.bookSlot(racerName)) {
            System.out.println("Slot booked successfully! Racer Names: " + selectedSlot.getBookedRacers());
            bookedTimeSlots.add(timeSlots.get(selectedSlotIndex - 1));
        } else {
            System.out.println("Slot is already full. Please select another slot.");
        }
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
        for (TimeSlot slot : bookedTimeSlots) {
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
    }

}
