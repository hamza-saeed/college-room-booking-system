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

public class OneBooking {
    
    OneRoom Room;
    String BookerName;
    String BookerEmail;
    String BookerPhone;
    String BookingNotes;
    
    public OneBooking(OneRoom room, String bookerName, String bookerEmail, String bookerPhone, String bookingNotes)
    {
        Room = room;
        BookerName = bookerName;
        BookerEmail = bookerEmail;
        BookerPhone = bookerPhone;
        BookingNotes = bookingNotes;
    }
    
    public OneRoom getRoom()
    {
        return Room;
    }
    
    public String getBookerName()
    {
        return BookerName;
    }
    
    public String getBookerEmail()
    {
        return BookerEmail;
    }
    
    public String getBookerPhone()
    {
        return BookerPhone;
    }
    
    public String getBookingNotes()
    {
        return BookingNotes;
    }
}
