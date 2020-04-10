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
public class OneUnavailability {
    
    private String RoomName;
    private LocalDate UnavailabilityStart;
    private LocalDate UnavailabilityEnd;
    private String Reason;
    
    public OneUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd, String reason)
    {
        RoomName = roomName;
        UnavailabilityStart = unavailStart;
        UnavailabilityEnd = unavailEnd;
        Reason = reason;
    }
    
    public String getRoomName() 
    {
        return RoomName;
    }
    
    public LocalDate returnUnavailStart()
    {
        return UnavailabilityStart;
    }
    
    public LocalDate returnUnavailEnd()
    {
        return UnavailabilityEnd;
    }
    
    public String returnReason()
    {
        return Reason;
    }
    
}
