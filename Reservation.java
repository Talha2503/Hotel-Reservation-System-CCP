import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private final Date bookingTimestamp;
    private Date checkInDate;
    private Date checkOutDate;
    private int roomQuantity; 
    private RoomType category; 
    private List<Room> assignedRooms;

    private Reservation(Date start, Date end, RoomType type, int num) {
 
        validateSchedule(start, end);
        
        this.bookingTimestamp = new Date(); 
        this.checkInDate = start;
        this.checkOutDate = end;
        this.roomQuantity = num;
        this.category = Objects.requireNonNull(type, "Room category cannot be null");
        this.assignedRooms = new ArrayList<>();
    }

    public Reservation(long id) {
        this.bookingTimestamp = new Date();
        this.assignedRooms = new ArrayList<>();
        System.out.println("Initialized reservation with ID reference: " + id);
    }

    public static Reservation create(Date start, Date end, RoomType type, int num) {
        return new Reservation(start, end, type, num);
    }

    private void validateSchedule(Date start, Date end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Reservation dates must be fully defined.");
        }
        if (end.before(start)) {
            throw new IllegalArgumentException("Schedule Error: Departure date precedes Arrival date.");
        }
    }

    public void addRoom(Room room) {
        if (Objects.nonNull(room)) {
            this.assignedRooms.add(room);
        }
    }

    public RoomType getRoomType() {
        return this.category;
    }
}
