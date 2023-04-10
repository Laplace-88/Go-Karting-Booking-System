package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private final String description;
    private final LocalDateTime timestamp;

    public Event(String name) {
        this.description = name;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeStamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() != this.getClass())
            return false;

        Event otherEvent = (Event) other;

        return (this.timestamp.equals(otherEvent.timestamp) &&
                (this.description.equals(otherEvent.description)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, timestamp);
    }

    @Override
    public String toString() {
        return timestamp.toString() + "\n" + description;
    }
}
