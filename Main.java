import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>> Initializing Hotel Management System <<<\n");
        
        try {
         
            Hotel_Chain industryGroup = new Hotel_Chain("Serena Group");
            Hotel flagshipBranch = new Hotel("Serena Islamabad");
            industryGroup.addHotel(flagshipBranch);

            RoomType luxuryTier = new RoomType("Deluxe", 25000.0);
            Room executiveRoom = new Room(101, luxuryTier);
            flagshipBranch.addRoom(executiveRoom);

            industryGroup.createReserverPayer("P-5501", "1234567812345678");
            
            ReserverPayer primaryPayer = ReserverPayer.create("P-5501", "1234567812345678");

            Date checkInDate = new Date();
            long sevenDaysInMillis = 7L * 24 * 60 * 60 * 1000;
            Date checkOutDate = new Date(checkInDate.getTime() + sevenDaysInMillis);
            
            Reservation currentBooking = Reservation.create(checkInDate, checkOutDate, luxuryTier, 1);
            
            industryGroup.makeReservation(primaryPayer, currentBooking);

            executiveRoom.createGuest("Ahmad Ali", "F-7, Islamabad");

            printReport(flagshipBranch, primaryPayer, luxuryTier);

        } catch (Exception ex) {
            System.err.println("Fatal System Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void printReport(Hotel h, ReserverPayer p, RoomType rt) {
        System.out.println("-------------------------------------------");
        System.out.println("          RESERVATION SUMMARY              ");
        System.out.println("-------------------------------------------");
        System.out.printf("Property     : %s%n", h.getName());
        System.out.printf("Client ID    : %s%n", p.getId());
        System.out.printf("Room Category: %s%n", rt.getKind());
        System.out.printf("Nightly Rate : %.2f%n", rt.getCost());
        System.out.println("-------------------------------------------");
        System.out.println("STATUS       : PROCESS COMPLETED SUCCESSFULLY");
        System.out.println("-------------------------------------------");
    }
}
