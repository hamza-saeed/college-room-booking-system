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
    
    private String RoomName;
    private String BookerName;
    private String BookerEmail;
    private String BookerPhone;
    private String BookingNotes;
    private LocalDate BookingDate;
    private TimeOfDay BookingTime;
    
    public OneBooking(String roomName, String bookerName, String bookerEmail, String bookerPhone, String bookingNotes,LocalDate bookingDate, TimeOfDay bookingTime)
    {
        RoomName = roomName;
        BookerName = bookerName;
        BookerEmail = bookerEmail;
        BookerPhone = bookerPhone;
        BookingNotes = bookingNotes;
        BookingDate = bookingDate;
        BookingTime = bookingTime;
    }
    
    public String getRoomName()
    {
        return RoomName;
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
