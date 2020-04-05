/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Hamza
 */
public class SharedBookings extends Observable {
       
    private ArrayList<OneRoom> listOfRooms = new ArrayList<OneRoom>();
    
    public SharedBookings()
    {
        super();
    }   
   
    public ArrayList<OneRoom> getTheRooms()
    {
        return listOfRooms;
    }
    
    public void addRoom(OneRoom newRoom)
    {
        listOfRooms.add(newRoom);
        setChanged();
        notifyObservers();
    }
}
