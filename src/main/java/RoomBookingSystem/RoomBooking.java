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
public class RoomBooking {
    
    public static void main(String args[])    
    {
         SharedBookings bookings = new SharedBookings();
                  
         RoomManagerGUI roomMan1 = new RoomManagerGUI(bookings);
         RoomBookerGUI roomBook1 = new RoomBookerGUI(bookings);
         RoomBookerGUI roomBook2 = new RoomBookerGUI(bookings);
         RoomBookerGUI roomBook3 = new RoomBookerGUI(bookings);

         
         Thread t1 = new Thread(roomMan1);
         Thread t2 = new Thread(roomBook1);
         Thread t3 = new Thread(roomBook2);
         Thread t4 = new Thread(roomBook3);

         
         t1.start();
         t2.start();
         t3.start();
         t4.start();
    
    }
}