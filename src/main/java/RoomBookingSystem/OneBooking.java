/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.time.LocalDate;

/**
 *
 * @author Hamza
 */

public class OneBooking {
    
    private OneRoom Room;
    private String BookerName;
    private String BookerEmail;
    private String BookerPhone;
    private String BookingNotes;
    private LocalDate BookingDate;
    private TimeOfDay BookingTime;
    
    public OneBooking(OneRoom room, String bookerName, String bookerEmail, String bookerPhone, String bookingNotes,LocalDate bookingDate, TimeOfDay bookingTime)
    {
        Room = room;
        BookerName = bookerName;
        BookerEmail = bookerEmail;
        BookerPhone = bookerPhone;
        BookingNotes = bookingNotes;
        BookingDate = bookingDate;
        BookingTime = bookingTime;
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
    
    public LocalDate getBookingDate()
    {
        return BookingDate;
    }
    
    public TimeOfDay getBookingTime()
    {
        return BookingTime;
    }
    
}
