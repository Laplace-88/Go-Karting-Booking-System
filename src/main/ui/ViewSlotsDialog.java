package ui;


import model.TimeSlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewSlotsDialog extends JDialog {
    private JPanel contentPane;
    private List<TimeSlot> slots;
    private MainMenu mainMenu;
    private JFrame parent;

    public ViewSlotsDialog(JFrame parent, MainMenu mainMenu) {
        super(parent, "Book Slot", true);
        this.parent = parent;
        this.mainMenu = mainMenu;
        setLayout(new GridLayout(24, 2));
        int slotIndex = 1;
        System.out.println(mainMenu.getTimeSlots());
        for (TimeSlot slot : mainMenu.getTimeSlots()) {
            if (slot.isAvailable()) {
                JButton slotTime = new JButton(slotIndex + ". " + slot.toString());
                JLabel remainingSlots = new JLabel("Racer Slots Remaining :: " + slot.getRemainingRacerSlots());
                add(slotTime);
                add(remainingSlots);
                // TODO:: ADD ACTION LISTENER
                slotTime.addActionListener(this::actionPerformed);
            }
            slotIndex++;
        }

        pack();
        setLocationRelativeTo(parent);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String timeSlot = button.getText();
        int selectedSlotIndex = Integer.parseInt(timeSlot.substring(0, timeSlot.indexOf(".")));
        TimeSlot selectedSlot = mainMenu.getTimeSlots().get(selectedSlotIndex - 1);
        BookSlotDialog bookslot = new BookSlotDialog(parent, mainMenu, selectedSlot, this);
        bookslot.setVisible(true);
        dispose();
    }
}