import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HotelChain {
   
    private String chainTitle;
    private List<Hotel> hotelRegistry;
    private List<ReserverPayer> registeredPayers;

    public HotelChain(String name) {
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

