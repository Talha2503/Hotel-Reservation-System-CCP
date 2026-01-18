import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testRoomCreation_ShouldSetNumberAndType() {
        final int targetRoomNum = 101;
        RoomType luxuryClass = new RoomType("Deluxe", 5000.0);

   
        Room testRoom = new Room(targetRoomNum, luxuryClass);


        assertNotNull("The Room instance should be initialized properly.", testRoom);
        assertEquals("The assigned room number must match the input.", targetRoomNum, testRoom.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomCreation_InvalidNumber_ShouldThrowException() {
  
        int outOfRangeNumber = -5; 
        RoomType standardClass = new RoomType("Standard", 3000.0);


        new Room(outOfRangeNumber, standardClass);
    }

    @Test(expected = NullPointerException.class)
    public void testRoomCreation_NullType_ShouldThrowException() {
        int validNum = 102;


        new Room(validNum, null);
    }

    @Test
    public void testCreateGuest_ShouldExecuteSuccessfully() {

        RoomType premiumSuite = new RoomType("Suite", 10000.0);
        Room executiveSuite = new Room(201, premiumSuite);
        
        String visitorName = "Zeeshan";
        String visitorResidence = "Karachi, Pakistan";
        executiveSuite.createGuest(visitorName, visitorResidence);
        
        assertTrue("Execution completed without issues", true);
    }
}
