package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeSlotTest {

    private TimeSlot slot;

    @BeforeEach
    public void setup() {
        slot = new TimeSlot(LocalTime.of(12, 0), 2);
    }

    @Test
    public void testIsAvailable() {
        assertTrue(slot.isAvailable());
        slot.bookSlot("Racer1");
        assertTrue(slot.isAvailable());
        slot.bookSlot("Racer2");
        assertFalse(slot.isAvailable());
    }

    @Test
    public void testBookSlot() {
        assertTrue(slot.bookSlot("Racer1"));
        assertTrue(slot.bookSlot("Racer2"));
        assertFalse(slot.bookSlot("Racer3"));
    }

    @Test
    public void testGetStartTime() {
        assertEquals(LocalTime.of(12, 0), slot.getStartTime());
    }

    @Test
    public void testGetEndTime() {
        assertEquals(LocalTime.of(12, 30), slot.getEndTime());
    }

    @Test
    public void testGetBookedRacers() {
        slot.bookSlot("Racer1");
        slot.bookSlot("Racer2");
        List<String> bookedRacers = slot.getBookedRacers();
        assertEquals(2, bookedRacers.size());
        assertTrue(bookedRacers.contains("Racer1"));
        assertTrue(bookedRacers.contains("Racer2"));
    }

    @Test
    public void testToString() {
        TimeSlot slot = new TimeSlot(LocalTime.of(12, 0), 2);
        assertEquals("12:00 - 12:30", slot.toString());
    }
}