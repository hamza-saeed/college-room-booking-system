package DataStructures;

//data structure used to return available rooms
import java.time.LocalDate;

public class OneAvailableRoom {

    private LocalDate Date;
    private TimeOfDay DayTime;
    private OneRoom Room;

    public OneAvailableRoom(LocalDate date, TimeOfDay dayTime, OneRoom room) {
        Date = date;
        DayTime = dayTime;
        Room = room;
    }

    public LocalDate getDate() {
        return Date;
    }

    public TimeOfDay getDayTime() {
        return DayTime;
    }

    public OneRoom getRoom() {
        return Room;
    }

}
