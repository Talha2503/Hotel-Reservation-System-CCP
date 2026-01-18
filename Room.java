public class Room {
    private int unitIdentifier;
    private RoomType category;  

 
    public Room(int roomNumber, RoomType roomCategory) {
    
        if (roomNumber < 1) {
            throw new IllegalArgumentException("Protocol Error: Room number must be a positive integer.");
        }
        if (roomCategory == null) {
            throw new NullPointerException("Reference Error: Associated RoomType is missing.");
        }
        
        this.unitIdentifier = roomNumber;
        this.category = roomCategory;
    }


    public void createGuest(String name, String address) {

        Guest occupant = new Guest(name, address);
        

        System.out.printf("System Alert: Resident [%s] has been assigned to Unit %d.%n", 
                          occupant.getName(), unitIdentifier);
    }


    public int getNumber() {
        return this.unitIdentifier;
    }
}
