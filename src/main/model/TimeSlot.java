package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeSlot {
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final int capacity;
    private final List<String> bookedRacers;

    public TimeSlot(LocalTime startTime, int capacity) {
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(30);
        this.capacity = capacity;
        this.bookedRacers = new ArrayList<>();
    }

    public boolean isAvailable() {
        return bookedRacers.size() < capacity;
    }

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

    @Override
    public String toString() {
        return startTime.toString() + " - " + endTime.toString();
    }
}
