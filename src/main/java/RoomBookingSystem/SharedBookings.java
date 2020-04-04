/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.util.Observable;

/**
 *
 * @author Hamza
 */
public class SharedBookings extends Observable {
   
    private String theStr;
    
    public SharedBookings()
    {
        super();
    }
    
    public String getTheBookings() 
    {
        return theStr;
    }
    
    public void setTheBookings(String theStr)
    {
        this.theStr = theStr;
        setChanged();
        notifyObservers();
    }
   
    
    
}
