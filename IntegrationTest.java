import java.util.Date;

public class IntegrationTest {
    public static void main(String[] args) {
        System.out.println("Starting System-Wide Integration Test...");
        
        try {
            Hotel luxuryResort = new Hotel("Beach Resort");
            RoomType premiumSuite = new RoomType("Suite", 50000.0);
            Room targetRoom = new Room(505, premiumSuite);
            
           
            luxuryResort.addRoom(targetRoom);

            ReserverPayer customer = ReserverPayer.create("P-100", "5555-4444-3333-2222");
            
            long currentTime = System.currentTimeMillis();
            Date checkIn = new Date(currentTime); 
            Date checkOut = new Date(currentTime + (5L * 24 * 60 * 60 * 1000)); // Calculating 5 days duration

           
            
           
            Reservation bookingEntry = Reservation.create(checkIn, checkOut, premiumSuite, 1);
            bookingEntry.addRoom(targetRoom); 
            
          
            luxuryResort.createReservation(bookingEntry);
            customer.makeReservation(bookingEntry);

            
            boolean systemAvailability = luxuryResort.available();
            boolean connectionVerified = (customer.getReservation() != null && customer.getReservation().equals(bookingEntry));

            if (systemAvailability && connectionVerified) {
                displaySuccessLog(luxuryResort, premiumSuite, customer);
            } else {
                System.err.println("❌ Integration Test Mismatch: Objects were not linked correctly.");
            }

        } catch (Exception ex) {
            System.err.println("❌ Critical Failure during Integration Test: " + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    private static void displaySuccessLog(Hotel h, RoomType rt, ReserverPayer p) {
        System.out.println("====================================================");
        System.out.println("✅ Integration Test Passed: End-to-end flow verified.");
        System.out.println("Confirmed Hotel: " + h.getName());
        System.out.println("Category Booked: " + rt.getKind());
        System.out.println("Customer Account: " + p.getId());
        System.out.println("====================================================");
    }
}