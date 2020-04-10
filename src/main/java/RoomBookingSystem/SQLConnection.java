/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hamza
 */
public class SQLConnection {

    private Connection con = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    SQLConnection() {
        final String url = "jdbc:sqlite:hamza.sqlite";

        System.out.println("Opening Connection...");
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException c) {
            System.err.println("Failed to Make Connection!");
            System.exit(1);
        }
        createTermTable();
        createRoomTable();
        createBookingTable();
        createUnavailabilityTable();
    }

    public void addTerm(LocalDate startDate, LocalDate endDate) {
        try {
            Statement s = con.createStatement();
            String value = "'" + startDate.format(formatter) + "','" + endDate.format(formatter) + "'";
            s.executeUpdate("insert into terms values (" + value + ");");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    public ResultSet getResults(String table) {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("select * from " + table);
        } catch (SQLException c) {
            c.printStackTrace();
        }
        return rs;
    }

    public void addRoom(String roomName, String roomType, int spaces) {
        try {
            Statement s = con.createStatement();
            String value = "'" + roomName + "','" + roomType + "'," + spaces;
            s.executeUpdate("insert into rooms values (" + value + ");");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    public void addBooking(String roomName, String bookerName, String bookerEmail, String bookerPhone, String bookingNotes, LocalDate bookingDate, String bookingTime) {
        try {
            Statement s = con.createStatement();
            String value = "'" + roomName + "','" + bookerName + "','" + bookerEmail + "','" + bookerPhone + "','" + bookingNotes + "','" + bookingDate.format(formatter) + "','" + bookingTime + "'";
            s.executeUpdate("insert into bookings values (" + value + ");");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    public void addUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd, String reason) {
        try {
            Statement s = con.createStatement();
            String value = "'" + roomName + "','" + unavailStart.format(formatter) + "','" + unavailEnd.format(formatter) + "','" + reason + "'";
            s.executeUpdate("insert into unavailabilities values (" + value + ");");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    public void deleteUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("delete from unavailabilities where RoomName = '" + roomName + "' AND UnavailabilityStart='" + unavailStart.format(formatter) + "' AND UnavailabilityEnd='" + unavailEnd.format(formatter) + "';");
        } catch (SQLException c) {
            c.printStackTrace();
        }
    }

    public void deleteRoom(String roomName) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("delete from rooms where RoomName = '" + roomName + "';");
        } catch (SQLException c) {
            c.printStackTrace();
        }
    }

    public void deleteTerm(LocalDate termBeginning, LocalDate termEnding) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("delete from terms where TermBeginning= '" + termBeginning.format(formatter) + "' AND TermEnding='" + termEnding.format(formatter) + "';");
        } catch (SQLException c) {
            c.printStackTrace();
        }
    }

    public void deleteBooking(String roomName, LocalDate bookingDate, TimeOfDay bookingTime) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("delete from bookings where RoomName= '" + roomName + "' AND BookingDate='" + bookingDate.format(formatter) + "' AND BookingTime='" + bookingTime.toString() + "';");
        } catch (SQLException c) {
            c.printStackTrace();
        }
    }

    private void createTermTable() {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("create table if not exists terms (TermBeginning TEXT, TermEnding TEXT);");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    private void createRoomTable() {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("create table if not exists rooms (RoomName TEXT, TypeOfRoom TEXT, Spaces INTEGER);");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    private void createBookingTable() {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("create table if not exists bookings (RoomName TEXT, BookerName TEXT, BookerEmail TEXT, BookerPhone TEXT, BookerNotes TEXT, BookingDate TEXT, BookingTime TEXT);");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

    private void createUnavailabilityTable() {
        try {
            Statement s = con.createStatement();
            s.executeUpdate("create table if not exists unavailabilities (RoomName TEXT, UnavailabilityStart TEXT, UnavailabilityEnd TEXT, Reason TEXT);");
        } catch (SQLException c) {
            c.printStackTrace();
            System.err.println("Failed to Create Data!");
            System.exit(1);
        }
    }

}
