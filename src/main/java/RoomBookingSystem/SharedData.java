/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.time.LocalDate;
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
    private ArrayList<OneUnavailability> listOfUnavailabilities = new ArrayList<OneUnavailability>();
    
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
    
    public void removeRoom(String roomName)
    {
        for (int i = 0; i < listOfRooms.size(); i++)
        {
            OneRoom room = listOfRooms.get(i);
            if (room.getRoomName().equals(roomName))
            {
                listOfRooms.remove(room);
            }
        }
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
    
    public void removeBooking(OneRoom room, LocalDate date, TimeOfDay time)
    {
        for (int i = 0; i < listOfBookings.size(); i++)
        {
            OneBooking booking = listOfBookings.get(i);
            if ((booking.getRoom().getRoomName().equals(room.getRoomName())) && (booking.getBookingDate().isEqual(date)) && (booking.getBookingTime().equals(time)))
            {
                listOfBookings.remove(booking);
            }
        }
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
        setChanged();
        notifyObservers();
    }
    
    public void removeTerm(LocalDate termBeginning, LocalDate termEnding)
    {
        for (int i = 0; i < listOfTerms.size(); i++)
        {
            OneTerm term = listOfTerms.get(i);
            if (term.getTermBeginning().isEqual(termBeginning) && (term.getTermEnding().isEqual(termEnding)))
            {
                listOfTerms.remove(term);
            }
        }
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<OneUnavailability> getTheUnavailabilities()
    {
        return listOfUnavailabilities;
    }
    
    public void addUnavailability(OneUnavailability newUnavailability)
    {
        listOfUnavailabilities.add(newUnavailability);
        setChanged();
        notifyObservers();
    }
    
    public void removeUnavailability(OneRoom room, LocalDate unavailStart, LocalDate unavailEnd)
    {
        for (int i = 0; i < listOfUnavailabilities.size(); i++)
        {
            OneUnavailability unavailability = listOfUnavailabilities.get(i);
            if (unavailability.getRoom().equals(room) && unavailability.returnUnavailStart().isEqual(unavailStart) && unavailability.returnUnavailEnd().isEqual(unavailEnd))
            {
                listOfUnavailabilities.remove(unavailability);
            }
        }
        setChanged();
        notifyObservers();
    }
    
}
