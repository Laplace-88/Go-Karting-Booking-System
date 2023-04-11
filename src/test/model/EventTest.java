package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    private Event event;

    @BeforeEach
    public void setUp() {
        event = new Event("test");
    }

    @Test
    public void testGetDescription() {
        String description = "Test event description";
        Event event = new Event(description);
        assertEquals(description, event.getDescription());
    }

    @Test
    public void testGetTimeStamp() {
        Event event = new Event("Test event description");
        LocalDateTime timeStamp = event.getTimeStamp();
        assertTrue(timeStamp.isBefore(LocalDateTime.now().plusSeconds(1))); // within one second of creation time
    }

    @Test
    public void testEquals() {
        TimeSlot slot = new TimeSlot(LocalTime.of(12, 0),5);
        Event event3 = new Event("other");
        assertFalse(event.equals(slot));
        assertTrue(event.equals(event));
        assertNotEquals(event, event3);
        assertFalse(event.equals(null));
    }

    @Test
    public void testHashCode() {
        Event event3 = new Event("other");

        assertNotEquals(event.hashCode(), event3.hashCode());
    }

    @Test
    public void testToString() {
        Event event = new Event("Test event description");
        String expectedString = event.getTimeStamp().toString() + "\n" + "Test event description";
        assertEquals(expectedString, event.toString());
    }
}