package model;

import ui.TakeInput;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneSelection {
    private static final String[] BRANDS = {"Apple", "Samsung", "Google"};
    ArrayList<String> selectedBrands = new ArrayList<>();
    private static final String[] PROCESSOR = {"Apple A16 Bionic", "Apple A15 Bionic", "Snapdragon 8 Gen 2",
            "Snapdragon 8+ Gen 1", "Snapdragon 8 Gen 1", "Snapdragon 888+", "Snapdragon 888", "Snapdragon 870",
            "Helio G96", "Helio G99", "Dimensity 700", "Dimensity 810", "Dimensity 900 Series",
            "Dimensity 1000 Series", "Dimensity 8000 Series", "Dimensity 9000 Series"};
    ArrayList<String> selectedProcessor = new ArrayList<>();
    private static final String[] OS = {"iOS", "Android 13", "Android 12", "Stock Android", "One UI"};
    ArrayList<String> selectedOS = new ArrayList<>();
    private static final String[] RAM = {"4GB", "6GB", "8GB", "10GB", "12GB", "16GB", "18GB"};
    ArrayList<String> selectedRAM = new ArrayList<>();
    private static final String[] STORAGE = {"32GB", "64GB", "128GB", "256GB", "512GB", "1TB"};
    ArrayList<String> selectedStorage = new ArrayList<>();
    private static final String[] DISPLAY = {"AMOLED", "90Hz+", "QHD+ Resolution"};
    ArrayList<String> selectedDisplay = new ArrayList<>();
    private static final String[] BATTERY_CAPACITY = {"3000 mAh+", "4000 mAh+", "5000mAh+", "6000 mAh+"};
    ArrayList<String> selectedBatteryCapacity = new ArrayList<>();
    private static final String BUDGET_RANGE = "0.00$ -- 9999.99$";
    Double selectedCostLL;
    Double selectedCostUL;
    Boolean fingerprintReader;
    Boolean quickCharging;
    Boolean wirelessCharging;
    Boolean fiveG;
    Boolean wifi6;
    Boolean bt5;
    Boolean nfc;
    Boolean stereoSpeakers;

    public PhoneSelection() {
        fingerprintReader = false;
        quickCharging = false;
        wirelessCharging = false;
        fiveG = false;
        wifi6 = false;
        bt5 = false;
        nfc = false;
        stereoSpeakers = false;
    }

    Scanner sc = new Scanner(System.in);

    public static void phoneSelection() {
        System.out.println("Please Enter Your Preferences. Enter 0 when you are done.");
        PhoneSelection ps = new PhoneSelection();
    }


}