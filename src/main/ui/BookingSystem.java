package ui;

import model.TimeSlot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    private final List<TimeSlot> timeSlots;
    private final List<TimeSlot> bookedTimeSlots;

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

    public void bookSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
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
            System.out.println("Slot booked successfully!");
            bookedTimeSlots.add(timeSlots.get(selectedSlotIndex - 1));
            timeSlots.remove(timeSlots.get(selectedSlotIndex - 1));
        } else {
            System.out.println("Slot is already full. Please select another slot.");
        }
    }

    public void cancelSlot() {
        System.out.println("Slots Currently Booked: ");
        System.out.println(bookedTimeSlots);
        System.out.println("Enter Slot ");
    }
}
