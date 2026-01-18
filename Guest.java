public class Guest {
    private String guestFullName;
    private String physicalAddress;

    public Guest() {
        this.guestFullName = "Unknown";
        this.physicalAddress = "Not Provided";
    }

    public Guest(String name, String addressDetails) {
        this.guestFullName = name;
        this.physicalAddress = addressDetails;
    }

    public String getName() {
        return this.guestFullName;
    }

    public String getAddressDetails() {
        return this.physicalAddress;
    }
    
    public Guest create(String name, String addressDetails) {
        Guest newGuest = (name != null && addressDetails != null) 
                         ? new Guest(name, addressDetails) 
                         : new Guest();
        return newGuest;
    }
}
