package ui;

import model.Event;
import model.EventLog;
import model.TimeSlot;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainMenu extends JFrame implements ActionListener {

    private List<TimeSlot> timeSlots;

    private final ArrayList<JButton> times;
    private JButton slotTime;
    private JPanel makeBookingPanel;
    private final JFrame frame;
    private final JPanel manageBookingPanel;
    private final JButton bookSlot;
    private final JButton cancelBooking;
    private final JButton logButton;
    private final JButton saveButton;
    private final JButton backButton;
    private final JButton loadButton;
    private final JButton quit;
    private String racerName;
    private TimeSlot selectedSlot;

    // Constructor
    public MainMenu() {
        this.timeSlots = new ArrayList<>();
        LocalTime time = LocalTime.of(12, 0);
        for (int i = 0; i < 24; i++) {
            TimeSlot slot = new TimeSlot(time, 10);
            timeSlots.add(slot);
            time = time.plusMinutes(30);
        }
        times = new ArrayList<>();
        slotTime = new JButton();
        frame = new JFrame();
        frame.setSize(500, 500);
        manageBookingPanel = new JPanel(new FlowLayout());
        bookSlot = new JButton("Book a Slot");
        backButton = new JButton("Back");
        cancelBooking = new JButton("Cancel a Booking");
        logButton = new JButton("Logs");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        quit = new JButton("Quit");
        buildSlotPage();
        layout();
    }

    // MODIFIES: this, makeBookingPanel, times, slotTime
    // EFFECTS: Builds the booking panel by adding buttons for each available time slot.
    public void buildSlotPage() {
        makeBookingPanel = new JPanel(new GridLayout(24, 2));
        int slotIndex = 1;
        for (TimeSlot slot : timeSlots) {
            if (slot.isAvailable()) {
                slotTime = new JButton(slotIndex + ". " + slot.toString());
                JLabel remainingSlots = new JLabel("Racer Slots Remaining :: " + slot.getRemainingRacerSlots());
                makeBookingPanel.add(slotTime);
                makeBookingPanel.add(remainingSlots);
                times.add(slotTime);
                slotTime.addActionListener(this);
            }
            slotIndex++;
        }
        frame.getContentPane().removeAll();
        frame.getContentPane().add(makeBookingPanel);
        frame.revalidate();
        frame.repaint();
    }

    // MODIFIES: this, frame, bookSlot, cancelBooking, saveButton, loadButton, quit, enterRacerText, submitButton
    // EFFECTS: Sets up the layout of the main menu.
    public void layout() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookSlot.setPreferredSize(new Dimension(150, 25));
        manageBookingPanel.add(bookSlot);
        bookSlot.addActionListener(this);
        manageBookingPanel.add(cancelBooking);
        cancelBooking.setPreferredSize(new Dimension(150, 25));
        cancelBooking.addActionListener(this);
        manageBookingPanel.add(logButton);
        logButton.setPreferredSize(new Dimension(150, 25));
        logButton.addActionListener(this);
        manageBookingPanel.add(saveButton);
        saveButton.setPreferredSize(new Dimension(150, 25));
        saveButton.addActionListener(this);
        manageBookingPanel.add(loadButton);
        loadButton.setPreferredSize(new Dimension(150, 25));
        loadButton.addActionListener(this);
        frame.setVisible(true);
        manageBookingPanel.add(quit);
        quit.setPreferredSize(new Dimension(150, 25));
        quit.addActionListener(this);
    }

    // MODIFIES: this, frame
    // EFFECTS: Switches to the manage booking panel.
    public void launchManageBooking() {
        frame.remove(makeBookingPanel);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(manageBookingPanel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    // MODIFIES: this, selectedSlot
    // EFFECTS: Prompts the user to enter the name of the racer who wants to book a time slot.
    //- Lists the available time slots and prompts the user to select a time slot to book.
    //- If the selected time slot is available, the slot is booked for the racer and their name is added to the list
    // of booked racers for the selected slot. The selected slot is also added to the list of booked time slots.
    //- If the selected time slot is already booked, a message is displayed informing the user that the slot is already
    // full.
    public void launchBookSlot() {
        frame.remove(manageBookingPanel);
        makeBookingPanel.repaint();
        buildSlotPage();
        frame.add(makeBookingPanel);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: - Prompts the user to enter the name of the racer whose booking they want to cancel.
    //- Searches through the list of booked time slots to find a slot that has been booked by the specified racer.
    //- If a slot is found, the racer's name is removed from the list of booked racers for the slot, and a message is
    // displayed informing the user that the booking has been cancelled.
    //- If no slot is found, a message is displayed informing the user that no booking was found for the specified
    // racer.
    public void launchCancelSlot() {
        String racerName = JOptionPane.showInputDialog(frame,
                "Enter the name of the racer whose booking you want to cancel:");
        boolean foundSlot = false;
        for (TimeSlot slot : timeSlots) {
            if (slot.cancelSlot(racerName)) {
                JOptionPane.showMessageDialog(frame, "Booking for " + racerName + " has been cancelled.");
                foundSlot = true;
            }
        }
        if (!foundSlot) {
            JOptionPane.showMessageDialog(frame, "No booking was found for " + racerName + ".");
        }
    }

    // EFFECTS: Prompts the user to enter a racer name and returns the input as a string.
    public String pullRacerName() {
        racerName = JOptionPane.showInputDialog(frame, "Racer Name");
        return racerName;
    }

    // MODIFIES: Bookings.json
    // EFFECTS: This method exports the start-time, end-time, capacity, booked racers and
    // remaining slots ArrayLists to the Bookings.json file
    private void saveBookingInfo() {
        JSONArray bookings = new JSONArray();
        for (TimeSlot slot : timeSlots) {
//            if (!slot.getBookedRacers().isEmpty()) {
            JSONObject booking = new JSONObject();
            booking.put("start_time", slot.getStartTime().toString());
            booking.put("end_time", slot.getEndTime().toString());
            booking.put("capacity", slot.getCapacity());
            booking.put("booked_racers", new JSONArray(slot.getBookedRacers()));
            booking.put("remaining_slots", slot.getRemainingRacerSlots());
            bookings.put(booking);
//            }
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

    // EFFECTS: Loads the booking information from the Bookings.json file and
    // updates the timeSlots ArrayList accordingly.
    @SuppressWarnings("methodlength")
    private void loadBookingInfo() {
        String jsonData;
        try {
            jsonData = readFile("Bookings.json");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to load the booking information.");
            e.printStackTrace();
            popup("An error occurred while trying to load the booking information.", "Failed");
            return;
        }
        JSONArray jsonObject = new JSONArray(jsonData);
        timeSlots = new ArrayList<>();
        if (jsonObject.length() == 0) {
            LocalTime time = LocalTime.of(12, 0);
            for (int i = 0; i < 24; i++) {
                TimeSlot slot = new TimeSlot(time, 10);
                timeSlots.add(slot);
                time = time.plusMinutes(30);
            }
        } else {
            for (Object obj : jsonObject) {
                JSONObject js = (JSONObject) obj;
                TimeSlot slot = new TimeSlot(js);
                timeSlots.add(slot);
            }
        }
    }

    // REQUIRES: The source file must exist.
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: Gives a popup to the user
    public void popup(String message, String title) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        final JDialog dialog = pane.createDialog(null, title);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Timer timer = new Timer(3000, evt -> dialog.dispose());
        timer.start(); // Set a timer to automatically close the popup after 3 seconds
        dialog.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: Shows the user all the event logs up-until then
    public void logs() {
        JTextArea logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        logTextArea.append("Event Logs: \n\n");
        for (Event e : EventLog.getInstance()) {
            logTextArea.append(e.getDescription() + " at " + e.getTimeStamp() + "\n\n");
        }
        JPanel logPanel = new JPanel();
        logPanel.add(scrollPane);
        backButton.addActionListener(this);
        logPanel.add(backButton);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(logPanel);
        frame.revalidate();
        frame.repaint();
    }

    @SuppressWarnings("methodlength")
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookSlot) {
            frame.setVisible(false);
            this.launchBookSlot();
        } else if (e.getSource() == cancelBooking) {
            this.launchCancelSlot();
        } else if (e.getSource() == saveButton) {
            saveBookingInfo();
            popup("Save Successful!", "Success");
        } else if (e.getSource() == loadButton) {
            loadBookingInfo();
            popup("Load Successful!", "Success");
        } else if (e.getSource() == logButton) {
            this.logs();
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            this.launchManageBooking();
        } else {
            frame.setVisible(false);
            if (e.getSource() == quit) {
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString() + "\n");
                }
                System.exit(0);
            } else {
                JButton button = (JButton) e.getSource();
                String timeSlot = button.getText();
                int selectedSlotIndex = Integer.parseInt(timeSlot.substring(0, timeSlot.indexOf(".")));
                selectedSlot = timeSlots.get(selectedSlotIndex - 1);
                racerName = this.pullRacerName();
                if (selectedSlot.bookSlot(racerName)) {
                    this.launchManageBooking();
                    popup("Booking Completed!", "Success");
                } else {
                    popup("Slot is already full. Please select another slot.", "Failed");
                }
            }
        }
    }
}