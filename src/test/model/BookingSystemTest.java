//import model.TimeSlot;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ui.BookingSystem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BookingSystemTest {
//
//    private BookingSystem bookingSystem;
//
//    @BeforeEach
//    public void setup() {
//        bookingSystem = new BookingSystem();
//    }
//
//    @Test
//    public void testGetTimeSlot() {
//        TimeSlot timeSlot = bookingSystem.getTimeSlot(0);
//        assertNotNull(timeSlot);
//        assertEquals(0, timeSlot.getIndex());
//    }
//
//    @Test
//    public void testBookSlot() {
//        TimeSlot timeSlot = bookingSystem.getTimeSlot(0);
//        String racerName = "John";
//        boolean isBooked = bookingSystem.bookSlot(timeSlot, racerName);
//        assertTrue(isBooked);
//        List<String> bookedRacers = timeSlot.getBookedRacers();
//        assertEquals(1, bookedRacers.size());
//        assertEquals(racerName, bookedRacers.get(0));
//    }
//
//    @Test
//    public void testBookSlotWhenFull() {
//        TimeSlot timeSlot = bookingSystem.getTimeSlot(0);
//        for (int i = 0; i < 10; i++) {
//            timeSlot.bookSlot("Racer " + i);
//        }
//        boolean isBooked = bookingSystem.bookSlot(timeSlot, "New Racer");
//        assertFalse(isBooked);
//        List<String> bookedRacers = timeSlot.getBookedRacers();
//        assertEquals(10, bookedRacers.size());
//    }
//
//    @Test
//    public void testCancelBooking() {
//        TimeSlot timeSlot = bookingSystem.getTimeSlot(0);
//        String racerName = "John";
//        bookingSystem.bookSlot(timeSlot, racerName);
//        boolean isCancelled = bookingSystem.cancelBooking(timeSlot, racerName);
//        assertTrue(isCancelled);
//        List<String> bookedRacers = timeSlot.getBookedRacers();
//        assertEquals(0, bookedRacers.size());
//    }
//
//    @Test
//    public void testCancelBookingWhenNotBooked() {
//        TimeSlot timeSlot = bookingSystem.getTimeSlot(0);
//        String racerName = "John";
//        boolean isCancelled = bookingSystem.cancelBooking(timeSlot, racerName);
//        assertFalse(isCancelled);
//    }
//
//    @Test
//    public void testGetAvailableSlots() {
//        List<TimeSlot> availableSlots = bookingSystem.getAvailableSlots();
//        assertNotNull(availableSlots);
//        assertEquals(24, availableSlots.size());
//        for (TimeSlot timeSlot : availableSlots) {
//            assertTrue(timeSlot.getBookedRacers().isEmpty());
//        }
//    }
//
//    @Test
//    public void testGetBookedSlots() {
//        List<TimeSlot> bookedSlots = bookingSystem.getBookedSlots();
//        assertNotNull(bookedSlots);
//        assertEquals(0, bookedSlots.size());
//        TimeSlot timeSlot = bookingSystem.getTimeSlot(0);
//        bookingSystem.bookSlot(timeSlot, "John");
//        bookedSlots = bookingSystem.getBookedSlots();
//        assertEquals(1, bookedSlots.size());
//    }
//
//    // Other test methods...
//}
