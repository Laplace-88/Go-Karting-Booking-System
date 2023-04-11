package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a log of go-karting booking system events.
 */
public class EventLog implements Iterable<Event> {
    private static EventLog instance;
    private final List<Event> events;

    // Constructor
    public EventLog() {
        this.events = new ArrayList<>();
    }

    // EFFECTS: returns the singleton instance of EventLog
    public static EventLog getInstance() {
        if (instance == null) {
            instance = new EventLog();
        }
        return instance;
    }

    // MODIFIES: this
    // EFFECTS: adds the given Event to the list of events
    public void logEvent(Event event) {
        events.add(event);
    }

    // MODIFIES: this
    // EFFECTS: clears the list of events and logs a new "Event log cleared" Event
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    // EFFECTS: returns an iterator over the events in the list
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
