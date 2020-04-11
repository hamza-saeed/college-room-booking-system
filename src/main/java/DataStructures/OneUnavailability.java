package DataStructures;

import java.time.LocalDate;

/**
 * Defines One Unavailability
 *
 * @author Hamza
 */
public class OneUnavailability {

    private String RoomName;
    private LocalDate UnavailabilityStart;
    private LocalDate UnavailabilityEnd;
    private String Reason;

    public OneUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd, String reason) {
        RoomName = roomName;
        UnavailabilityStart = unavailStart;
        UnavailabilityEnd = unavailEnd;
        Reason = reason;
    }

    public String getRoomName() {
        return RoomName;
    }

    public LocalDate returnUnavailStart() {
        return UnavailabilityStart;
    }

    public LocalDate returnUnavailEnd() {
        return UnavailabilityEnd;
    }

    public String returnReason() {
        return Reason;
    }

}
