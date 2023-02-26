package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loginSuccessful = false;
        LogIn loggedIn = new LogIn();
        while (!loginSuccessful) {
            loginSuccessful = loggedIn.logIn();
        }
        BookingSystem bookingSystem = new BookingSystem();
        boolean isBookingComplete = false;
        while (!isBookingComplete) {
            System.out.println("Welcome to the Gokarting Booking System");
            System.out.println("1. Book a slot");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
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
    }
}