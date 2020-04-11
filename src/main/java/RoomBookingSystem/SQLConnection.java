package RoomBookingSystem;

import DataStructures.TimeOfDay;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SQLConnection {

    private Connection con = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Boolean dbAccess = true;

    SQLConnection() {
        //connect to database
        final String url = "jdbc:sqlite:db.sqlite";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException c) {
            System.err.println("Failed to Make Connection! Persistence Disabled");
            //if connection failed, disable db storage
            dbAccess = false;
        }
        //create necessary tables (if they don't already exist)
        createTermTable();
        createRoomTable();
        createBookingTable();
        createUnavailabilityTable();
    }

    public ResultSet getResults(String table) {
        ResultSet rs = null;
        if (dbAccess) {
            try {
                //return all data from selected table
                Statement s = con.createStatement();
                rs = s.executeQuery("select * from " + table);
            } catch (SQLException c) {
                c.printStackTrace();
            }
        }
        return rs;
    }

    private void executeUpdate(String query) {
        if (dbAccess) {
            try {
                //execute query
                Statement s = con.createStatement();
                s.executeUpdate(query);
            } catch (SQLException c) {
                c.printStackTrace();
            }
        }
    }

    public void addTerm(LocalDate startDate, LocalDate endDate) {
        //add new query
        String query = "insert into terms values ('" + startDate.format(formatter) + "','" + endDate.format(formatter) + "');";
        executeUpdate(query);
    }

    public void addRoom(String roomName, String roomType, int spaces) {
        //add new room
        String query = "insert into rooms values ('" + roomName + "','" + roomType + "'," + spaces + ");";
        executeUpdate(query);
    }

    public void addBooking(String roomName, String bookerName, String bookerEmail, String bookerPhone, String bookingNotes, LocalDate bookingDate, String bookingTime) {
        //add new booking
        String query = "insert into bookings values ('" + roomName + "','" + bookerName + "','" + bookerEmail + "','" + bookerPhone + "','" + bookingNotes + "','" + bookingDate.format(formatter) + "','" + bookingTime + "');";
        executeUpdate(query);
    }

    public void addUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd, String reason) {
        //add new unavailability
        String query = "insert into unavailabilities values ('" + roomName + "','" + unavailStart.format(formatter) + "','" + unavailEnd.format(formatter) + "','" + reason + "');";
        executeUpdate(query);
    }

    public void deleteUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd) {
        //delete unavailability matching given attributes
        String query = "delete from unavailabilities where RoomName = '" + roomName + "' AND UnavailabilityStart='" + unavailStart.format(formatter) + "' AND UnavailabilityEnd='" + unavailEnd.format(formatter) + "';";
        executeUpdate(query);
    }

    public void deleteRoom(String roomName) {
        //delete room matching given attributes
        String query = "delete from rooms where RoomName = '" + roomName + "';";
        executeUpdate(query);
    }

    public void deleteTerm(LocalDate termBeginning, LocalDate termEnding) {
        //delete term matching given attributes
        String query = "delete from terms where TermBeginning= '" + termBeginning.format(formatter) + "' AND TermEnding='" + termEnding.format(formatter) + "';";
        executeUpdate(query);
    }

    public void deleteBooking(String roomName, LocalDate bookingDate, TimeOfDay bookingTime) {
        //delete booking matching given attributes
        String query = "delete from bookings where RoomName= '" + roomName + "' AND BookingDate='" + bookingDate.format(formatter) + "' AND BookingTime='" + bookingTime.toString() + "';";
        executeUpdate(query);
    }

    private void createTermTable() {
        //create table for terms if it doesn't exist
        String query = "create table if not exists terms (TermBeginning TEXT, TermEnding TEXT);";
        executeUpdate(query);
    }

    private void createRoomTable() {
        //create table for rooms if it doesn't exist
        String query = "create table if not exists rooms (RoomName TEXT, TypeOfRoom TEXT, Spaces INTEGER);";
        executeUpdate(query);
    }

    private void createBookingTable() {
        //create table for bookings if it doesn't exist
        String query = "create table if not exists bookings (RoomName TEXT, BookerName TEXT, BookerEmail TEXT, BookerPhone TEXT, BookerNotes TEXT, BookingDate TEXT, BookingTime TEXT);";
        executeUpdate(query);
    }

    private void createUnavailabilityTable() {
        //create table for unavailabilities if it doesn't exist
        String query = "create table if not exists unavailabilities (RoomName TEXT, UnavailabilityStart TEXT, UnavailabilityEnd TEXT, Reason TEXT);";
        executeUpdate(query);
    }

}
