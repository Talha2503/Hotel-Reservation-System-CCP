public class HowMany {
    private int quantityValue; 

  
    public HowMany(int number) {
 
        validateQuantity(number);
        this.quantityValue = number;
    }

    private void validateQuantity(int val) {
        if (val < 1) {
            throw new IllegalArgumentException("Constraint Violation: Room count must be at least 1.");
        }
    }


    public int getNumber() {
        return this.quantityValue;
    }
}
