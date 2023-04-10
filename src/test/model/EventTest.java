package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

public class EventTest {

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
        Event event = new Event("Test event description");
        assertEquals(event, event);
    }

    @Test
    public void testToString() {
        Event event = new Event("Test event description");
        String expectedString = event.getTimeStamp().toString() + "\n" + "Test event description";
        assertEquals(expectedString, event.toString());
    }
}