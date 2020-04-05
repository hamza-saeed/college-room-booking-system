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
public class OneTerm {
    
    LocalDate TermBeginning;
    LocalDate TermEnding;
    
    public OneTerm(LocalDate termBeginning, LocalDate termEnding)
    {
        TermBeginning = termBeginning;
        TermEnding = termEnding;
    }
    
    public LocalDate getTermBeginning()
    {
        return TermBeginning;
    }
    
    public LocalDate getTermEnding()
    {
        return TermEnding;
    }
}
    

