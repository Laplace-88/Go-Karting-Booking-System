package ui;

import java.util.ArrayList;
import java.util.Scanner;

import static model.LaptopSelection.*;

public class TakeInput {
    ArrayList<String> selectedBrands = new ArrayList<>();
    ArrayList<String> selectedScreenSize = new ArrayList<>();
    ArrayList<String> selectedProcessor = new ArrayList<>();
    ArrayList<String> selectedOS = new ArrayList<>();
    ArrayList<String> selectedGraphicCard = new ArrayList<>();
    ArrayList<String> selectedRAM = new ArrayList<>();
    ArrayList<String> selectedStorage = new ArrayList<>();
    ArrayList<String> selectedDisplay = new ArrayList<>();
    Boolean touchscreen;
    Boolean fingerprintReader;
    Boolean backlitKeyboard;
    Boolean thinlight;
    ArrayList<String> selectedWarranty = new ArrayList<>();
    Double selectedCostLL;
    Double selectedCostUL;

    Scanner sc = new Scanner(System.in);

    @SuppressWarnings("methodlength")
    public void getReq(String category, String req) {
        System.out.println("Please Enter Your Preferences. Enter 0 when you are done.");
        switch (category) {
            case "l":
                switch (req) {
                    case "Brand":
                        getLBrand();
                        break;
                    case "Screen Size":
                        getLScreenSize();
                        break;
                    case "Processor":
                        getLProcessor();
                        break;
                    case "OS":
                        getLOS();
                        break;
                    case "Graphic Card":
                        getLGraphicCard();
                        break;
                    case "RAM":
                        getLram();
                        break;
                    case "Storage":
                        getLStorage();
                        break;
                    case "Display":
                        getLDisp();
                        break;
                    case "Touch Screen":
                        getLTouchScreen();
                        break;
                    case "Fingerprint Reader":
                        getLFingerprintReader();
                        break;
                    case "Backlit Keyboard":
                        getLBacklitKeyboard();
                        break;
                    case "Thin and Light":
                        getLThinLight();
                        break;
                    case "Warranty":
                        getLWarranty();
                        break;
                    case "Budget":
                        getLBudget();
                        break;
                }
                break;
            case "p":
                switch (req) {
                    case "Brand":
                        getPBrand();
                        break;
                    case "Processor":
                        getPProcessor();
                        break;
                    case "OS":
                        getPOS();
                        break;
                    case "RAM":
                        getPram();
                        break;
                    case "Storage":
                        getPStorage();
                        break;
                    case "Display":
                        getPDisp();
                        break;
                    case "Battery":
                        getPBattery();
                        break;
                    case "Budget":
                        getPBudget();
                        break;
                }
                break;

        }
    }

    public void getLBrand() {
        int selection;
        do {
            System.out.println("BRANDS: Acer(1), Apple(2), Asus(3), Dell(4), HP(5), Lenovo(6), Microsoft(7)");
            selection = sc.nextInt();
        } while (selection > 7 || selection < 0);
        while (selection != 0) {
            if (selection > 7 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedBrands.add(BRANDS[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLScreenSize() {
        int selection;
        do {
            System.out.println("Screen Size: 10-11(1), 11-12(2), 12-13(3), 13-14(4), 14-15(5), 15-16(6), 16-17(7)");
            selection = sc.nextInt();
        } while (selection > 7 || selection < 0);
        while (selection != 0) {
            if (selection > 7 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedScreenSize.add(SCREEN_SIZE[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLProcessor() {
        char selection;
        do {
            System.out.println("Processor: Apple Silicon M1(A), Apple Silicon M1 Pro(B), Apple Silicon M1 Max(C),");
            System.out.println(" Apple Silicon M1 Ultra(D), Apple Silicon M2(E), Apple Silicon M2 Pro(F),");
            System.out.println(" Apple Silicon M2 Max(G), Intel i5 (11th Gen)(H), Intel i5 (12th Gen)(I),");
            System.out.println(" Intel i5 (13th Gen)(J), Intel i7 (11th Gen)(K), Intel i7 (12th Gen)(L),");
            System.out.println(" Intel i7 (13th Gen)(M), Intel i7 (13th Gen)(N), Intel i9 (11th Gen)(O)");
            System.out.println(" Intel i9 (12th Gen)(P), Intel i9 (13th Gen)(Q), AMD Ryzen 5 5000 series(R),");
            System.out.println(" AMD Ryzen 7 5000 series(S), AMD Ryzen 9 5000 series(T), AMD Ryzen 5 6000 series(U),");
            System.out.println(" AMD Ryzen 7 6000 series(V), AMD Ryzen 9 6000 series(W), AMD Ryzen 5 7000 series(X),");
            System.out.println(" AMD Ryzen 7 7000 series(Y), AMD Ryzen 9 7000 series(Z)");
            selection = Character.toLowerCase(sc.next().charAt(0));
            if (selection == 48) {
                break;
            }
        } while (selection > 122 || selection < 97);
        while (selection != 48) {
            if (selection > 122 || selection < 97) {
                System.out.println("Invalid Selection. Please retry.");
                selection = Character.toLowerCase(sc.next().charAt(0));
            } else {
                selectedProcessor.add(PROCESSOR[selection - 97]);
                selection = Character.toLowerCase(sc.next().charAt(0));
            }
        }
    }

    public void getLOS() {
        int selection;
        do {
            System.out.println("OS: Windows(1), MacOS(2), Linux(3)");
            selection = sc.nextInt();
        } while (selection > 3 || selection < 0);
        while (selection != 0) {
            if (selection > 3 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedOS.add(OS[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLGraphicCard() {
        int selection;
        do {
            System.out.println("Graphic Card: Integrated Graphics(1), Nvidia Geforce RTX 2000 Series(2), ");
            System.out.println("Nvidia Geforce RTX 3000 Series(3), Nvidia Geforce RTX 4000 Series(4), ");
            System.out.println("AMD Radeon RX 6000 Series(5), AMD Radeon RX 7000 Series(6)");
            selection = sc.nextInt();
        } while (selection > 6 || selection < 0);
        while (selection != 0) {
            if (selection > 6 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedGraphicCard.add(GRAPHIC_CARD[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLram() {
        int selection;
        do {
            System.out.println("RAM: 4GB(1), 8GB(2), 12GB(3), 16GB(4), 24GB(5), 32GB(6), 64GB(7), 96GB(8)");
            selection = sc.nextInt();
        } while (selection > 8 || selection < 0);
        while (selection != 0) {
            if (selection > 8 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedRAM.add(RAM[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLStorage() {
        int selection;
        do {
            System.out.println("Storage: 256GB(1), 512GB(2), 1TB(3), 2TB(4), 2TB+(5)");
            selection = sc.nextInt();
        } while (selection > 5 || selection < 0);
        while (selection != 0) {
            if (selection > 5 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedStorage.add(STORAGE[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLDisp() {
        int selection;
        do {
            System.out.println("Display: IPS/OLED/mLED(1), 90Hz+(2), FHD Resolution(3), 2K Resolution(4), ");
            System.out.println("4K Resolution(5), High Color Gamut(6), 300+ nits Brightness(7), Glossy(8), Matte(9)");
            selection = sc.nextInt();
        } while (selection > 9 || selection < 0);
        while (selection != 0) {
            if (selection > 9 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedDisplay.add(DISPLAY[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLTouchScreen() {
        char selection;
        Boolean valid = false;
        do {
            System.out.println("Would you prefer a touch display? (Y/N)");
            selection = Character.toLowerCase(sc.next().charAt(0));
            if (selection == 121 || selection == 110) {
                valid = true;
            }
        } while (!valid);
        if (selection == 121) {
            this.touchscreen = true;
        } else {
            this.touchscreen = false;
        }
    }

    public void getLFingerprintReader() {
        char selection;
        Boolean valid = false;
        do {
            System.out.println("Would you prefer a Fingerprint Reader? (Y/N)");
            selection = Character.toLowerCase(sc.next().charAt(0));
            if (selection == 121 || selection == 110) {
                valid = true;
            }
        } while (!valid);
        if (selection == 121) {
            this.fingerprintReader = true;
        } else {
            this.fingerprintReader = false;
        }
    }

    public void getLBacklitKeyboard() {
        char selection;
        Boolean valid = false;
        do {
            System.out.println("Would you prefer a Fingerprint Reader? (Y/N)");
            selection = Character.toLowerCase(sc.next().charAt(0));
            if (selection == 121 || selection == 110) {
                valid = true;
            }
        } while (!valid);
        if (selection == 121) {
            this.backlitKeyboard = true;
        } else {
            this.backlitKeyboard = false;
        }
    }

    public void getLThinLight() {
        char selection;
        Boolean valid = false;
        do {
            System.out.println("Would you prefer a Thin & Light Laptop? (Y/N)");
            selection = Character.toLowerCase(sc.next().charAt(0));
            if (selection == 121 || selection == 110) {
                valid = true;
            }
        } while (!valid);
        if (selection == 121) {
            this.thinlight = true;
        } else {
            this.thinlight = false;
        }
    }

    public void getLWarranty() {
        int selection;
        do {
            System.out.println("Warranty: 1 Year(1), 2 Years(2), 3 Years(3), 4 Years(4), 5 Years(5), 5+ Years(6)");
            selection = sc.nextInt();
        } while (selection > 7 || selection < 0);
        while (selection != 0) {
            if (selection > 7 || selection < 0) {
                System.out.println("Invalid Selection. Please retry.");
                selection = sc.nextInt();
            } else {
                selectedWarranty.add(WARRANTY[selection - 1]);
                selection = sc.nextInt();
            }
        }
    }

    public void getLBudget() {
        double ll;
        double ul;
        System.out.println("Enter your Budget Range ::");
        System.out.println(BUDGET_RANGE);
        System.out.print("Lower Limit :: ");
        ll = sc.nextDouble();
        if (ll < 0.00) {
            ll = 0.00;
        }
        System.out.print("Upper Limit :: ");
        ul = sc.nextDouble();
        if (ul > 9999.99) {
            ul = 9999.99;
        }
        if (ll > ul) {
            double temp = ll;
            ll = ul;
            ul = temp;
        }
        this.selectedCostLL = ll;
        this.selectedCostUL = ul;
    }

    public void getPBrand() {
    }

    public void getPProcessor() {
    }

    public void getPOS() {
    }

    public void getPram() {
    }

    public void getPStorage() {
    }

    public void getPDisp() {
    }

    public void getPBattery() {
    }

    public void getPBudget() {
    }
}
