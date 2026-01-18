import static org.junit.Assert.*;
import org.junit.Test;

public class HowManyTest {

    @Test
    public void testHowManyCreation_ShouldSetValidNumber() {
 
        int requestedQuantity = 5;
        HowMany quantityObject = new How_Many(requestedQuantity);

      
        assertEquals("The stored count must match the initial input", 
                     requestedQuantity, quantityObject.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHowMany_WithZero_ShouldThrowException() {
  
        int zeroCount = 0;
        new HowMany(zeroCount);
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHowMany_WithNegativeNumber_ShouldThrowException() {
    
        int outOfBoundsValue = -10;
        new How_Many(outOfBoundsValue);
    }
}
