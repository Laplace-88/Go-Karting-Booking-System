package model;

import org.json.JSONArray;
import org.json.JSONObject;

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

    // Constructor for loading
    public TimeSlot(JSONObject obj) {
        this.startTime = LocalTime.parse(obj.getString("start_time"));
        this.capacity = obj.getInt("capacity");
        this.endTime = LocalTime.parse(obj.getString("end_time"));
        JSONArray bookedRacersArray = obj.getJSONArray("booked_racers");
        this.bookedRacers = new ArrayList<>();
        for (Object o : bookedRacersArray) {
            String racer = (String) o;
            this.bookedRacers.add(racer);
        }
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

    public int getCapacity() {
        return capacity;
    }

    public int getRemainingRacerSlots() {
        return capacity - bookedRacers.size();
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
