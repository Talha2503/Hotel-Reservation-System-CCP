public class GuestTest {
    public static void main(String[] args) {
        
        String inputName = "Talha";
        String inputAddress = "talha @example.com";

       
        Guest testSubject = new Guest(inputName, inputAddress);

     
        boolean isNameCorrect = testSubject.getName().equalsIgnoreCase(inputName);
        boolean isAddressCorrect = testSubject.getAddressDetails().equals(inputAddress);

        
        if (isNameCorrect && isAddressCorrect) {
            System.out.println(">>> Validation Successful: Guest profile created correctly.");
            System.out.println("Verified Name: " + testSubject.getName());
        } else {
            System.err.println(">>> Validation Alert: Integrity check failed for Guest class.");
        }
    }
}

HotelChain:
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel_Chain {
  
    private String chainTitle;
    
    
    private List<Hotel> hotelRegistry;
    private List<ReserverPayer> registeredPayers;

   
    public Hotel_Chain(String name) {
        this.chainTitle = name;
        this.hotelRegistry = new ArrayList<>();
        this.registeredPayers = new ArrayList<>();
    }

    public void createReserverPayer(String id, String card) {
     
        ReserverPayer member = ReserverPayer.create(id, card);
        if (member != null) {
            this.registeredPayers.add(member);
        }
    }

    public void addPayer(ReserverPayer payer) {
       
        if (Objects.nonNull(payer)) {
            this.registeredPayers.add(payer);
        }
    }

    
    public void makeReservation(ReserverPayer payer, Reservation res) {
       
        boolean isAuthorized = registeredPayers.stream()
                                .anyMatch(p -> p.equals(payer));
        
        if (isAuthorized) {
            payer.makeReservation(res);
        }
    }

   
    public void addHotel(Hotel hotel) {
        this.hotelRegistry.add(hotel);
    }

   
    public void cancelReservation() { 
        System.out.println("Processing: Reservation has been revoked.");
    }

    public void checkInGuest() {
        System.out.println("Status: Guest entry recorded successfully.");
    }

    public void checkOutGuest() { 
        System.out.println("Status: Guest departure finalized.");
    }
}
