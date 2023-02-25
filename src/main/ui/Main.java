package ui;

import java.util.Scanner;

import static model.LaptopSelection.laptopSelection;
import static model.PhoneSelection.phoneSelection;

public class Main extends LogIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean loginSuccessful = false;
        while (!loginSuccessful) {
            loginSuccessful = logIn();
        }
        System.out.println("Hi! What are you looking for Today?");
        String productType; //Type of Product the user is looking for
        Boolean valid; //If the user made valid selection
        do {
            System.out.println("Enter L for Laptop, P for Phone, C for Car ::");
            productType = sc.nextLine().toLowerCase();
            if (productType.equals("l") || productType.equals("p") || productType.equals("c")) {
                valid = true;
            } else {
                System.out.println("Invalid Selection. Please retry ::");
                valid = false;
            }
        } while (!valid);
        switch (productType) {
            case "l":
                laptopSelection();
                break;
            case "p":
                phoneSelection();
                break;
            case "c":
                //TODO
                break;
        }
    }
}
