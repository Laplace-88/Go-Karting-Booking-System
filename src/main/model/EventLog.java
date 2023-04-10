package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventLog implements Iterable<Event> {
    private static EventLog instance;
    private final List<Event> events;

    public EventLog() {
        this.events = new ArrayList<>();
    }

    public static EventLog getInstance() {
        if (instance == null) {
            instance = new EventLog();
        }
        return instance;
    }

    public void logEvent(Event event) {
        events.add(event);
    }

    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    public List<Event> getEventLog() {
        return events;
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
