package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeSlotTest {

    private TimeSlot timeSlot;

    @BeforeEach
    public void setUp() {
        timeSlot = new TimeSlot(LocalTime.of(9, 0), 2);
    }

    @Test
    public void testIsAvailable() {
        assertTrue(timeSlot.isAvailable());
        timeSlot.bookSlot("Alice");
        assertTrue(timeSlot.isAvailable());
        timeSlot.bookSlot("Bob");
        assertFalse(timeSlot.isAvailable());
    }

    @Test
    public void testBookSlot() {
        assertTrue(timeSlot.bookSlot("Alice"));
        assertEquals(List.of("Alice"), timeSlot.getBookedRacers());
        assertTrue(timeSlot.bookSlot("Bob"));
        assertEquals(List.of("Alice", "Bob"), timeSlot.getBookedRacers());
        assertFalse(timeSlot.bookSlot("Charlie"));
        assertEquals(List.of("Alice", "Bob"), timeSlot.getBookedRacers());
    }

    @Test
    public void testGetStartTime() {
        assertEquals(LocalTime.of(9, 0), timeSlot.getStartTime());
    }

    @Test
    public void testGetEndTime() {
        assertEquals(LocalTime.of(9, 30), timeSlot.getEndTime());
    }

    @Test
    public void testGetBookedRacers() {
        assertTrue(timeSlot.getBookedRacers().isEmpty());
        timeSlot.bookSlot("Alice");
        assertEquals(List.of("Alice"), timeSlot.getBookedRacers());
        timeSlot.bookSlot("Bob");
        assertEquals(List.of("Alice", "Bob"), timeSlot.getBookedRacers());
    }

    @Test
    public void testToString() {
        assertEquals("09:00 - 09:30", timeSlot.toString());
    }
}
