import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTypeTest {

    @Test
    public void testRoomTypeCreation_ShouldSetCorrectValues() {
        String targetCategory = "Deluxe";
        double expectedNightlyRate = 25000.0;


        RoomType variant = new RoomType(targetCategory, expectedNightlyRate);

        assertEquals("The room category name must be assigned correctly.", 
                     targetCategory, variant.getKind());
        

        assertEquals("The nightly rate should match the input price.", 
                     expectedNightlyRate, variant.getCost(), 0.001); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomTypeCreation_NegativeCost_ShouldThrowException() {

        String standardKind = "Standard";
        double invalidNegativeRate = -100.0;


        new RoomType(standardKind, invalidNegativeRate);
    }
}
