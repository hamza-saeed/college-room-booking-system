
import DataStructures.OneBooking;
import DataStructures.OneRoom;
import DataStructures.OneTerm;
import DataStructures.OneUnavailability;
import DataStructures.TimeOfDay;
import DataStructures.TypeOfRoom;
import RoomBookingSystem.RoomBookingFunctions;
import RoomBookingSystem.SharedData;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestClass {
    
    SharedData bookings = new SharedData();

   
    @Test
    public void testAddRoom()
    {
        //New Test Room
        OneRoom testRoom = new OneRoom("TestRoom",TypeOfRoom.COMPUTER_LAB,20);
        //Add it
        bookings.addRoom(testRoom);
        //Return room from list with name 'TestRoom'
        OneRoom returnedRoom = RoomBookingFunctions.getRoomFromName(bookings.getTheRooms(), "TestRoom");
        //Make sure they're equal
        assertEquals(testRoom.getRoomName(),returnedRoom.getRoomName());
    }
    
    @Test
    public void testRemoveRoom()
    {
        //remove room with name 'TestRoom'
        bookings.removeRoom("TestRoom");
        //get room with name 'TestRoom'
        OneRoom returnedRoom = RoomBookingFunctions.getRoomFromName(bookings.getTheRooms(), "TestRoom");
        //Make sure it's null as room with that name was deleted above
        assertEquals(returnedRoom,null);
    }
    
    @Test
    public void testAddBooking()
    {
        //New Test Booking 1yr from today in 'TestRoom' in afternoon
        OneBooking testBooking = new OneBooking("TestRoom","TestBooker","TestEmail","TestPhone","TestNotes",LocalDate.now().plusYears(1),TimeOfDay.AFTERNOON);
        //Add it
        bookings.addBooking(testBooking);
        //Check if booking for room on date added (1yr from now) exists
        boolean doesBookingExist = RoomBookingFunctions.doesBookingExist(bookings.getTheBookings(), "TestRoom", LocalDate.now().plusYears(1), TimeOfDay.AFTERNOON);
        //Make sure booking does exist after it was entered
        assertEquals(doesBookingExist,true);
    }
    
    @Test
    public void testRemoveBooking()
    {
        //Remove booking 1yr from today in 'TestRoom' in afternoon
        bookings.removeBooking("TestRoom", LocalDate.now().plusYears(1),TimeOfDay.AFTERNOON);
        //Check if booking for room on date added (1yr from now) exists
        boolean doesBookingExist = RoomBookingFunctions.doesBookingExist(bookings.getTheBookings(), "TestRoom", LocalDate.now().plusYears(1), TimeOfDay.AFTERNOON);
        //Make sure booking does not exist as it was removed
        assertEquals(doesBookingExist,false);
    }
    
    @Test
    public void testAddTerm()
    {
        //add new term for 2 years from today till 2 days after 2 years from now
        OneTerm testTerm = new OneTerm(LocalDate.now().plusYears(2),LocalDate.now().plusYears(2).plusDays(2));
        //add new term
        bookings.addTerm(testTerm);
        //call method to check if given date (1 day after 2 years from now) is within any terms stored
        boolean isDateBetweenTerms = RoomBookingFunctions.isDateWithinTerm(bookings.getTheTerms(), LocalDate.now().plusYears(2).plusDays(1));
        //make sure it's true as one was just added that the given date is between
        assertEquals(isDateBetweenTerms,true);
    }
    
    @Test
    public void testRemoveTerm()
    {
        //remove the term added for the test (for 2 years from today till 2 days after 2 years from now)
        bookings.removeTerm(LocalDate.now().plusYears(2),LocalDate.now().plusYears(2).plusDays(2));
        //call method to check if given date (1 day after 2 years from now) is within any terms stored
        boolean isDateBetweenTerms = RoomBookingFunctions.isDateWithinTerm(bookings.getTheTerms(), LocalDate.now().plusYears(2).plusDays(1));
        //make sure it is false (as term was deleted)
        assertEquals(isDateBetweenTerms,false);
    }
    
    @Test
    public void testAddUnavailability()
    {
        //add new unavailability for 'TestRoom' 2 yrs from now till 2 years + 2 days from now
        OneUnavailability testUnavail = new OneUnavailability("TestRoom",LocalDate.now().plusYears(2),LocalDate.now().plusYears(2).plusDays(2),"TestReason");
        //add unavailability
        bookings.addUnavailability(testUnavail);
        //check if room is unavailable for 2 years and 1 day from now
        boolean isUnavailOnDay = RoomBookingFunctions.isRoomUnavailable(bookings.getTheUnavailabilities(), "TestRoom", LocalDate.now().plusYears(2).plusDays(1));
        //make sure it's true as the unavailability was just added
        assertEquals(isUnavailOnDay,true);
    }
    
    @Test
    public void testRemoveUnavailability()
    {
        //remove new unavailability for 'TestRoom' 2 yrs from now till 2 years + 2 days from now
        bookings.removeUnavailability("TestRoom",LocalDate.now().plusYears(2),LocalDate.now().plusYears(2).plusDays(2));
        //check if room is unavailable for 2 years and 1 day from now
        boolean isUnavailOnDay = RoomBookingFunctions.isRoomUnavailable(bookings.getTheUnavailabilities(), "TestRoom", LocalDate.now().plusYears(2).plusDays(1));
        //make sure it's false as the unavailability was just removed
        assertEquals(isUnavailOnDay,false);
    }
    
}
