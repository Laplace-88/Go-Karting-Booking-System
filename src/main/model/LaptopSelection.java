package model;

import ui.TakeInput;

public class LaptopSelection extends TakeInput {
    public static final String[] BRANDS = {"Acer", "Apple", "Asus", "Dell", "HP", "Lenovo", "Microsoft"};
    public static final String[] SCREEN_SIZE = {"10\"-11\"", "11\"-12\"", "12\"-13\"", "13\"-14\"", "14\"-15\"",
            "15\"-16\"", "16\"-17\""};
    public static final String[] PROCESSOR = {"Apple Silicon M1", "Apple Silicon M1 Pro", "Apple Silicon M1 Max",
            "Apple Silicon M1 Ultra", "Apple Silicon M2", "Apple Silicon M2 Pro", "Apple Silicon M2 Max",
            "Intel i5 (11th Gen)", "Intel i5 (12th Gen)", "Intel i5 (13th Gen)", "Intel i7 (11th Gen)",
            "Intel i7 (12th Gen)", "Intel i7 (13th Gen)", "Intel i7 (13th Gen)", "Intel i9 (11th Gen)",
            "Intel i9 (12th Gen)", "Intel i9 (13th Gen)", "AMD Ryzen 5 5000 series", "AMD Ryzen 7 5000 series",
            "AMD Ryzen 9 5000 series", "AMD Ryzen 5 6000 series", "AMD Ryzen 7 6000 series", "AMD Ryzen 9 6000 series",
            "AMD Ryzen 5 7000 series", "AMD Ryzen 7 7000 series", "AMD Ryzen 9 7000 series"};
    public static final String[] OS = {"Windows", "MacOS", "Linux"};
    public static final String[] GRAPHIC_CARD = {"Intel Integrated Graphics", "Nvidia GeForce RTX 2000 Series",
            "Nvidia GeForce RTX 3000 Series", "Nvidia GeForce RTX 4000 Series"};
    public static final String[] RAM = {"4GB", "8GB", "12GB", "16GB", "24GB", "32GB", "64GB", "96GB"};
    public static final String[] STORAGE = {"256GB", "512GB", "1TB", "2TB", "2TB+"};
    public static final String[] DISPLAY = {"IPS/OLED/mLED", "90Hz+", "FHD Resolution", "2K Resolution",
            "4K Resolution", "High Color Gamut", "300+ nits Brightness", "Glossy", "Matte"};
    public static final String[] WARRANTY = {"1 Year", "2 Years", "3 Years", "4Years", "5 Years", "5 Years+"};
    public static final String BUDGET_RANGE = "0.00$ -- 9999.99$";
    Boolean touchscreen;
    Boolean fingerprintReader;
    Boolean backlitKeyboard;
    Boolean thinlight;
    Double selectedCostLL;
    Double selectedCostUL;

    public LaptopSelection() {
        touchscreen = false;
        fingerprintReader = false;
        backlitKeyboard = false;
        thinlight = false;
        selectedCostLL = 0.0;
        selectedCostUL = 0.0;
    }

    public static void laptopSelection() {
        LaptopSelection ls = new LaptopSelection();
        ls.selectBrand();
        ls.selectScreenSize();
        ls.selectProcessor();
        ls.selectOS();
        ls.selectGraphicCard();
        ls.selectRAM();
        ls.selectStorage();
        ls.selectDisplay();
        ls.selectTouchScreen();
        ls.selectFingerprintReader();
        ls.selectBacklitKeyboard();
        ls.selectThinLight();
        ls.selectWarranty();
        ls.selectBudget();
    }

    private void selectBrand() {
        this.getReq("l", "Brand");
    }

    private void selectScreenSize() {
        this.getReq("l", "Screen Size");
    }

    private void selectProcessor() {
        this.getReq("l", "Processor");
    }

    private void selectOS() {
        this.getReq("l", "OS");
    }

    private void selectGraphicCard() {
        this.getReq("l", "Graphic Card");
    }

    private void selectRAM() {
        this.getReq("l", "RAM");
    }

    private void selectStorage() {
        this.getReq("l", "Storage");
    }

    private void selectDisplay() {
        this.getReq("l", "Display");
    }

    private void selectTouchScreen() {
        this.getReq("l", "Touch Screen");
    }

    private void selectFingerprintReader() {
        this.getReq("l", "Fingerprint Reader");
    }

    private void selectBacklitKeyboard() {
        this.getReq("l", "Backlit Keyboard");
    }

    private void selectThinLight() {
        this.getReq("l", "Thin and Light");
    }

    private void selectWarranty() {
        this.getReq("l", "Warranty");
    }

    private void selectBudget() {
        this.getReq("l", "Budget");
    }
}