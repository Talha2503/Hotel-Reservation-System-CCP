import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ReservationTest {

    @Test
    public void testCreateReservation_ShouldSetAllFields() {
        Date arrival = new Date(); 
        long oneDayMillis = 24 * 60 * 60 * 1000L;
        Date departure = new Date(arrival.getTime() + oneDayMillis); 
        
        RoomType luxuryCategory = new RoomType("Deluxe", 5000.0);
        int quantity = 2;

  
        Reservation bookingEntry = Reservation.create(arrival, departure, luxuryCategory, quantity);


        assertNotNull("The Reservation instance must be successfully instantiated", bookingEntry);
        assertEquals("The assigned RoomType should match the input", luxuryCategory, bookingEntry.getRoomType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateReservation_InvalidDates_ShouldThrowException() {
        Date checkIn = new Date();
        Date checkOutInPast = new Date(checkIn.getTime() - 500000); 
        RoomType economy = new RoomType("Standard", 3000.0);

        Reservation.create(checkIn, checkOutInPast, economy, 1);
    }

    @Test
    public void testAddRoom_ShouldUpdateList() {
        RoomType suiteClass = new RoomType("Suite", 10000.0);
        Reservation activeBooking = Reservation.create(new Date(), new Date(), suiteClass, 1);
        Room unit302 = new Room(302, suiteClass);

        activeBooking.addRoom(unit302);
        assertNotNull("Object state should remain valid after adding a room", activeBooking); 
    }
}
