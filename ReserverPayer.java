import java.util.Objects;

public class ReserverPayer {
    private String payerIdentity;
    private String cardInformation;
    private Reservation linkedReservation;


    public ReserverPayer(String id, String creditCardDetails) {
        this.payerIdentity = id;
        this.cardInformation = creditCardDetails;
    }


    public static ReserverPayer create(String id, String creditCardDetails) {

        if (id == null || id.trim().isEmpty() || creditCardDetails == null) {
            throw new IllegalArgumentException("Account Error: ID and Financial credentials must be provided.");
        }
        return new ReserverPayer(id, creditCardDetails);
    }

    public String getId() {
        return this.payerIdentity;
    }

    public String getCreditCardDetails() {
        return this.cardInformation;
    }


    public void makeReservation(Reservation res) {
        this.linkedReservation = Objects.requireNonNull(res, "Cannot link a null reservation to payer.");
        
        System.out.printf("Transaction Log: Reservation successfully processed for Payer [%s].%n", payerIdentity);
    }

    public Reservation getReservation() {
        return this.linkedReservation;
    }
}
