package model;

import ui.TakeInput;

import java.util.ArrayList;

public class PhoneSelection extends TakeInput {
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
        selectedCostLL = 0.0;
        selectedCostUL = 0.0;
        fingerprintReader = false;
        quickCharging = false;
        wirelessCharging = false;
        fiveG = false;
        wifi6 = false;
        bt5 = false;
        nfc = false;
        stereoSpeakers = false;
    }

    PhoneSelection s1 = new PhoneSelection();

    public static void phoneSelection() {
        PhoneSelection ps = new PhoneSelection();
        ps.selectBrand();
        ps.selectScreenSize();
        ps.selectProcessor();
        ps.selectOS();
        ps.selectGraphicCard();
        ps.selectRAM();
        ps.selectStorage();
        ps.selectDisplay();
        ps.selectTouchScreen();
        ps.selectFingerprintReader();
        ps.selectBacklitKeyboard();
        ps.selectThinLight();
        ps.selectWarranty();
        ps.selectBudget();
    }

    public void selectBrand() {
        s1.getReq("p", "Brand");
    }

    public void selectScreenSize() {
        s1.getReq("p", "Screen Size");
    }

    public void selectProcessor() {
        s1.getReq("p", "Processor");
    }

    public void selectOS() {
        s1.getReq("p", "OS");
    }

    public void selectGraphicCard() {
        s1.getReq("p", "Graphic Card");
    }

    public void selectRAM() {
        s1.getReq("p", "RAM");
    }

    public void selectStorage() {
        s1.getReq("p", "Storage");
    }

    public void selectDisplay() {
        s1.getReq("p", "Display");
    }

    public void selectTouchScreen() {
        s1.getReq("p", "Touch Screen");
    }

    public void selectFingerprintReader() {
        s1.getReq("p", "Fingerprint Reader");
    }

    public void selectBacklitKeyboard() {
        s1.getReq("p", "Backlit Keyboard");
    }

    public void selectThinLight() {
        s1.getReq("p", "Thin and Light");
    }

    public void selectWarranty() {
        s1.getReq("p", "Warranty");
    }

    public void selectBudget() {
        s1.getReq("p", "Budget");
    }
}