import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ReserverPayerTest {

    @Test
    public void testCreateReserverPayer_ShouldSetCorrectDetails() {
        final String uniqueId = "P-101";
        final String cardNumber = "1234-5678-9012";

        ReserverPayer clientInstance = ReserverPayer.create(uniqueId, cardNumber);

        assertNotNull("The ReserverPayer instance must be successfully created.", clientInstance);
        assertEquals("The stored ID should match the input ID.", uniqueId, clientInstance.getId());
        assertEquals("The card information should be stored correctly.", cardNumber, clientInstance.getCreditCardDetails());
    }

    @Test
    public void testMakeReservation_ShouldLinkReservationToPayer() {
        ReserverPayer subject = ReserverPayer.create("USER-001", "8888-7777");
        Reservation activeBooking = new Reservation(System.currentTimeMillis()); 

        subject.makeReservation(activeBooking);

        assertNotNull("The link to the reservation should not be null after mapping.", subject.getReservation());
        assertSame("The mapped reservation must be identical to the provided object.", activeBooking, subject.getReservation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_WithNullId_ShouldThrowException() {
        String missingId = null;
        String validCard = "1111-2222";

        ReserverPayer.create(missingId, validCard);
    }
}
