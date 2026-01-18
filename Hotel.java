import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hotel {
    private String branchName; 
    private List<Room> inventory; 
    private List<Reservation> bookingRecords;

  
    public Hotel(String name) {
       
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid Hotel Name: Name must be provided.");
        }
        this.branchName = name;
        this.inventory = new ArrayList<>();
        this.bookingRecords = new ArrayList<>();
    }

  
    public boolean available() {
       
        return this.inventory.size() > 0;
    }


    public void createReservation(Reservation res) {
      
        Optional.ofNullable(res)
                .ifPresentOrElse(
                    r -> {
                        this.bookingRecords.add(r);
                        System.out.printf("Log: New booking confirmed at [%s]%n", branchName);
                    },
                    () -> { throw new NullPointerException("Error: Reservation object is null"); }
                );
    }


    public void addRoom(Room room) {
        if (room != null) {
            this.inventory.add(room);
        }
    }

    public String getName() {
        return this.branchName;
    }
}
