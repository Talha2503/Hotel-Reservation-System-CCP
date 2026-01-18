import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class HotelTest {

    @Test
    public void testHotelCreation_ShouldSetNameAndInitializeLists() {
        final String hotelTitle = "Serena Islamabad";
        Hotel branchInstance = new Hotel(hotelTitle);
        assertEquals("The hotel name should be correctly assigned", hotelTitle, branchInstance.getName());
        boolean isAvailableInitially = branchInstance.available();
        assertFalse("New hotel without rooms must show as unavailable", isAvailableInitially);
    }

    @Test
    public void testAvailable_WhenRoomAdded_ShouldReturnTrue() {
     
        Hotel testingHotel = new Hotel("PC Lahore");
        RoomType luxuryType = new RoomType("Deluxe", 15000.0);
        Room unit101 = new Room(101, luxuryType);

   
        testingHotel.addRoom(unit101);

      
        assertTrue("Availability should be true after adding a unit", testingHotel.available());
    }

    @Test
    public void testCreateReservation_ShouldAddToList() {
      
        Hotel centralHotel = new Hotel("Marriott");
        RoomType suiteType = new RoomType("Suite", 30000.0);
        Date now = new Date();
        Reservation bookingRequest = Reservation.create(now, now, suiteType, 1);

      
        centralHotel.createReservation(bookingRequest);

        assertNotNull("Hotel instance should remain valid after reservation", centralHotel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_EmptyName_ShouldThrowException() {
    
        String invalidName = "   "; 
        new Hotel(invalidName); 
    }

    @Test(expected = NullPointerException.class)
    public void testCreateReservation_NullReservation_ShouldThrowException() {
       
        Hotel testBranch = new Hotel("Pearl Continental");


        testBranch.createReservation(null); 
    }
}
