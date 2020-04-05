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
public class SharedData extends Observable {
       
    private ArrayList<OneRoom> listOfRooms = new ArrayList<OneRoom>();
    private ArrayList<OneBooking> listOfBookings = new ArrayList<OneBooking>();
    private ArrayList<OneTerm> listOfTerms = new ArrayList<OneTerm>();
    
    public SharedData()
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
    
    public ArrayList<OneBooking> getTheBookings()
    {
        return listOfBookings;
    }
    
    public void addBooking(OneBooking newBooking)
    {
        listOfBookings.add(newBooking);
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<OneTerm> getTheTerms()
    {
        return listOfTerms;
    }
    
    public void addTerm(OneTerm newTerm)
    {
        listOfTerms.add(newTerm);
    }
}
