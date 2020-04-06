
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

/**
 *
 * @author Hamza
 */
public class OneRoom {
    
    private String RoomName;
    private TypeOfRoom RoomType;
    private int Spaces;
    
    public OneRoom(String roomName, TypeOfRoom roomType, int spaces)
    {
        RoomName = roomName;
        RoomType = roomType;
        Spaces = spaces;
    }
    
    public String getRoomName()
    {
        return RoomName;
    }
    
    public TypeOfRoom getTypeOfRoom()
    {
        return RoomType;
    }
    
    public int getSpaces()
    {
        return Spaces;
    }
    

}


