package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a Go-Karting System Event
 */
public class Event {
    private final String description;
    private final LocalDateTime timestamp;


    // MODIFIES: this
    // EFFECTS: constructs a new Event with the given description and sets the timestamp to the current time
    public Event(String description) {
        Objects.requireNonNull(description, "Description cannot be null");
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeStamp() {
        return timestamp;
    }

    // EFFECTS: returns true if this object is the same as the other object, false otherwise
    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Event otherEvent = (Event) other;

        return this.timestamp.equals(otherEvent.timestamp)
                &&
                this.description.equals(otherEvent.description);
    }

    // EFFECTS: returns a hash code value for this object
    @Override
    public int hashCode() {
        return Objects.hash(description, timestamp);
    }

    // EFFECTS: returns a string representation of the object
    @Override
    public String toString() {
        return timestamp.toString() + "\n" + description;
    }
}
