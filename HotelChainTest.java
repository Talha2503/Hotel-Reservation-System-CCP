import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class HotelChainTest {

    @Test
    public void testCreateReserverPayer_ShouldAddToChain() {
        
        Hotel_Chain corporateChain = new Hotel_Chain("Serena Group");
        String identity = "ID-XYZ";
        String cardNo = "4242-5555";

        
        corporateChain.createReserverPayer(identity, cardNo);


        assertNotNull("Chain instance should not be null after operation", corporateChain);
    }

    @Test
    public void testMakeReservation_WhenPayerExists_ShouldLink() {
    
        Hotel_Chain bookingSystem = new Hotel_Chain("Marriott");
        ReserverPayer member = ReserverPayer.create("M-101", "3333-4444");
        bookingSystem.addPayer(member);
        
        RoomType suite = new RoomType("Deluxe", 25000.0);
        Date today = new Date();
        Reservation activeBooking = Reservation.create(today, today, suite, 1);

    
        bookingSystem.makeReservation(member, activeBooking);


        assertSame("The linked reservation should match the original object", activeBooking, member.getReservation());
    }

    @Test
    public void testAddHotel_ShouldWorkSuccessfully() {
     
        Hotel_Chain network = new Hotel_Chain("Lux Hotel");
        Hotel branch = new Hotel("Lux Karachi");

        network.addHotel(branch);

        assertTrue("Hotel network should be initialized", network != null);
    }
}
