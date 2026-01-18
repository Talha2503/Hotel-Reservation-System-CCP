import java.util.Objects;

public class RoomType {

    private String categoryName;  
    private double nightlyRate;   

    public RoomType(String kind, double cost) {

        if (cost < 0.0) {
            throw new IllegalArgumentException("Financial Error: Room rate cannot be less than zero.");
        }
        
        this.categoryName = Objects.requireNonNull(kind, "Category kind must not be null");
        
        if (this.categoryName.trim().isEmpty()) {
            throw new IllegalArgumentException("Entry Error: Room category name is required.");
        }

        this.nightlyRate = cost;
    }

    public double getCost() { 
        return this.nightlyRate; 
    }
    
    public String getKind() { 
        return this.categoryName; 
    }
}
