package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventLogTest {

    private EventLog eventLog;

    @BeforeEach
    public void setUp() {
        eventLog = new EventLog();
    }

    @Test
    public void testLogEvent() {
        Event event = new Event("Test Event");
        eventLog.logEvent(event);
        List<Event> events = eventLog.getEventLog();
        assertEquals(1, events.size());
        assertEquals(event, events.get(0));
    }

    @Test
    public void testClear() {
        eventLog.logEvent(new Event("Test Event 1"));
        eventLog.logEvent(new Event("Test Event 2"));
        eventLog.clear();
        List<Event> events = eventLog.getEventLog();
        assertEquals(1, events.size()); // should be 1, not 0
        assertEquals("Event log cleared.", events.get(0).getDescription());
    }

    @Test
    public void testIterator() {
        eventLog.logEvent(new Event("Test Event 1"));
        eventLog.logEvent(new Event("Test Event 2"));
        eventLog.logEvent(new Event("Test Event 3"));
        int count = 0;
        for (Event event : eventLog) {
            count++;
        }
        assertEquals(3, count);
    }


}

