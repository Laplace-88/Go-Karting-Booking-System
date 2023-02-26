package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 This class represents a time slot for go-kart racing.
 It contains information about the start and end times of the slot,
 the capacity of the slot, and the list of racers who have booked the slot.
 */

public class TimeSlot {
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final int capacity;
    private final List<String> bookedRacers;

    // Constructor
    public TimeSlot(LocalTime startTime, int capacity) {
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(30);
        this.capacity = capacity;
        this.bookedRacers = new ArrayList<>();
    }

    // EFFECTS: returns true if the number of booked racers is less than the capacity of the time slot; false otherwise
    public boolean isAvailable() {
        return bookedRacers.size() < capacity;
    }

    // REQUIRES: racerName is not null
    // MODIFIES: this
    // EFFECTS: adds the specified racer to the list of booked racers and returns true if the time slot is available;
    //          returns false otherwise
    public boolean bookSlot(String racerName) {
        if (isAvailable()) {
            bookedRacers.add(racerName);
            return true;
        }
        return false;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public List<String> getBookedRacers() {
        return bookedRacers;
    }

    // EFFECTS: returns a string representation of the time slot in the format "startTime - endTime"
    @Override
    public String toString() {
        return startTime.toString() + " - " + endTime.toString();
    }
}
