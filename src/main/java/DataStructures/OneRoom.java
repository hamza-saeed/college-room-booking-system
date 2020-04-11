package DataStructures;

/**
 * Defines One Room
 *
 * @author Hamza
 */
public class OneRoom {

    private String RoomName;
    private TypeOfRoom RoomType;
    private int Spaces;

    public OneRoom(String roomName, TypeOfRoom roomType, int spaces) {
        RoomName = roomName;
        RoomType = roomType;
        Spaces = spaces;
    }

    public String getRoomName() {
        return RoomName;
    }

    public TypeOfRoom getTypeOfRoom() {
        return RoomType;
    }

    public int getSpaces() {
        return Spaces;
    }

}
