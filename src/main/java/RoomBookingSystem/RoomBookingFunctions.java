package RoomBookingSystem;

import DataStructures.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RoomBookingFunctions {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //returns full room details from name
    public static OneRoom getRoomFromName(ArrayList<OneRoom> rooms, String name) {
        //iterate through room and return room if found
        for (OneRoom room : rooms) {
            if (room.getRoomName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    //Check if booking already exists
    public static boolean doesBookingExist(ArrayList<OneBooking> bookings, String roomName, LocalDate bookingDate, TimeOfDay bookingTime) {
        //iterate through bookings and return true if found, false if not found 
        for (OneBooking booking : bookings) {
            if (booking.getRoomName().equals(roomName) && booking.getBookingDate().isEqual(bookingDate) && (booking.getBookingTime().equals(bookingTime))) {
                return true;
            }
        }
        return false;
    }

    //Check if an unavailability has been added for chosen dates
    public static boolean isRoomUnavailable(ArrayList<OneUnavailability> unavailabilities, String roomName, LocalDate bookingDate) {
        //iterate through unavailabilities to see if there is a match
        for (OneUnavailability unavail : unavailabilities) {
            if ((unavail.getRoomName().equals(roomName)) && (isWithin(bookingDate, unavail.returnUnavailStart(), unavail.returnUnavailEnd()))) {
                return true;
            }
        }

        return false;
    }

    //Checks if date is on or between two other dates
    private static boolean isWithin(LocalDate bookingDate, LocalDate dateComp1, LocalDate dateCom2) {
        return ((bookingDate.isAfter(dateComp1) && bookingDate.isBefore(dateCom2)) || (bookingDate.isEqual(dateComp1)) || (bookingDate.isEqual(dateCom2)));
    }

    //Check if date is within any terms
    public static boolean isDateWithinTerm(ArrayList<OneTerm> terms, LocalDate date) {
        boolean dateWithinTerm = false;
        //iterate through terms to see if query date falls within any added terms
        for (OneTerm term : terms) {
            if (isWithin(date, term.getTermBeginning(), term.getTermEnding())) {
                dateWithinTerm = true;
            }
        }

        return dateWithinTerm;
    }

    //find available bookings on a certain day
    public static ArrayList<OneAvailableRoom> getAvailableBookingsOnDay(ArrayList<OneBooking> bookings, ArrayList<OneRoom> rooms, ArrayList<OneTerm> terms, ArrayList<OneUnavailability> unavailabilities, String dateText, String roomType) {
        LocalDate date = LocalDate.parse(dateText, formatter);
        ArrayList<OneAvailableRoom> availableRooms = new ArrayList<OneAvailableRoom>();
        ArrayList<TimeOfDay> times = new ArrayList<TimeOfDay>();
        boolean dateWithinTerm = RoomBookingFunctions.isDateWithinTerm(terms, date);
        //calculate times available based on days of week and whether the date is within a term
        if ((date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) || (!dateWithinTerm)) {
            times.add(TimeOfDay.MORNING);
            times.add(TimeOfDay.AFTERNOON);
            times.add(TimeOfDay.EVENING);
        } else {
            times.add(TimeOfDay.EVENING);
        }
        //iterate through rooms
        for (OneRoom room : rooms) {
            //iterate through times
            for (TimeOfDay time : times) {
                //add to list of available rooms if booking on that day/time doesn't already exist
                if (!RoomBookingFunctions.doesBookingExist(bookings, room.getRoomName(), date, time) && (!RoomBookingFunctions.isRoomUnavailable(unavailabilities, room.getRoomName(), date))) {
                    if ((room.getTypeOfRoom().equals(RoomBookingFunctions.returnRoomTypeFromString(roomType))) || (roomType.equals("Any"))) {
                        OneAvailableRoom availRoom = new OneAvailableRoom(date, time, RoomBookingFunctions.getRoomFromName(rooms, room.getRoomName()));
                        availableRooms.add(availRoom);
                    }
                }
            }
        }
        return availableRooms;
    }

    //find available bookings for the next fortnight
    public static ArrayList<OneAvailableRoom> getAvailableBookingsWithinAFortnight(ArrayList<OneBooking> bookings, ArrayList<OneRoom> rooms, ArrayList<OneTerm> terms, ArrayList<OneUnavailability> unavailabilities) {
        LocalDate todaysDate = LocalDate.now();
        ArrayList<OneAvailableRoom> availableRooms = new ArrayList<OneAvailableRoom>();
        //for the next 2 weeks days
        for (int i = 0; i <= 14; i++) {
            ArrayList<TimeOfDay> times = new ArrayList<TimeOfDay>();
            LocalDate date = todaysDate.plusDays(i);
            boolean dateWithinTerm = RoomBookingFunctions.isDateWithinTerm(terms, date);
            //calculate times available based on days of week and whether the date is within a term
            if ((date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) || (!dateWithinTerm)) {
                times.add(TimeOfDay.MORNING);
                times.add(TimeOfDay.AFTERNOON);
                times.add(TimeOfDay.EVENING);
            } else {
                times.add(TimeOfDay.EVENING);
            }
            //iterate through rooms
            for (OneRoom room : rooms) {
                //iterate through times
                for (TimeOfDay time : times) {
                    //add to list of available rooms if booking on that day/time doesn't already exist
                    if (!RoomBookingFunctions.doesBookingExist(bookings, room.getRoomName(), date, time) && (!RoomBookingFunctions.isRoomUnavailable(unavailabilities, room.getRoomName(), date))) {
                        OneAvailableRoom availRoom = new OneAvailableRoom(date, time, RoomBookingFunctions.getRoomFromName(rooms, room.getRoomName()));
                        availableRooms.add(availRoom);
                    }
                }
            }
        }
        return availableRooms;
    }

    public static TimeOfDay returnTimeFromString(String time) {
        TimeOfDay bookingTime = (time.equals("MORNING")) ? TimeOfDay.MORNING : (time.equals("AFTERNOON")) ? TimeOfDay.AFTERNOON : (time.equals("EVENING")) ? TimeOfDay.EVENING : null;
        return bookingTime;
    }

    public static TypeOfRoom returnRoomTypeFromString(String type) {
        TypeOfRoom roomType = (type.equals("COMPUTER_LAB")) ? TypeOfRoom.COMPUTER_LAB : (type.equals("TUTORIAL_ROOM")) ? TypeOfRoom.TUTORIAL_ROOM : (type.equals("LECTURE_THEATRE")) ? TypeOfRoom.LECTURE_THEATRE : null;
        return roomType;
    }
}
