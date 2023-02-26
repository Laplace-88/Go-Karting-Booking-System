package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LogIn loggedIn = new LogIn();
        loggedIn.logIn();
        BookingSystem bookingSystem = new BookingSystem();
        boolean isBookingComplete = false;
        while (!isBookingComplete) {
            System.out.println("Welcome to the Gokarting Booking System \n1. Book a slot\n2. Cancel a booking");
            System.out.println("3. Exit \nEnter your choice: ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            switch (choice) {
                case 1:
                    bookingSystem.bookSlot();
                    break;
                case 2:
                    bookingSystem.cancelSlot();
                    break;
                case 3:
                    isBookingComplete = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
