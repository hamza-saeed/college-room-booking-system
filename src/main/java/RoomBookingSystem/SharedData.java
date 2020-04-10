/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Hamza
 */
public class SharedData extends Observable {

    private ArrayList<OneRoom> listOfRooms = new ArrayList<OneRoom>();
    private ArrayList<OneBooking> listOfBookings = new ArrayList<OneBooking>();
    private ArrayList<OneTerm> listOfTerms = new ArrayList<OneTerm>();
    private ArrayList<OneUnavailability> listOfUnavailabilities = new ArrayList<OneUnavailability>();
    SQLConnection sqlConn = new SQLConnection();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public SharedData() {
        super();
        loadTerms();
        loadRooms();
        loadBookings();
        loadUnavailabilities();
    }

    private void loadTerms() {
        try {
            ResultSet rs = sqlConn.getResults("terms");
            while (rs.next()) {
                OneTerm oneTerm = new OneTerm(LocalDate.parse(rs.getString(1), formatter), LocalDate.parse(rs.getString(2), formatter));
                listOfTerms.add(oneTerm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadRooms() {
        try {
            ResultSet rs = sqlConn.getResults("rooms");
            while (rs.next()) {
                String roomTypeStr = rs.getString(2);
                TypeOfRoom roomType = (roomTypeStr.equals("COMPUTER_LAB")) ? TypeOfRoom.COMPUTER_LAB : (roomTypeStr.equals("TUTORIAL_ROOM")) ? TypeOfRoom.TUTORIAL_ROOM : (roomTypeStr.equals("LECTURE_THEATRE")) ? TypeOfRoom.LECTURE_THEATRE : null;
                OneRoom oneRoom = new OneRoom(rs.getString(1), roomType, rs.getInt(3));
                listOfRooms.add(oneRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBookings() {
        try {
            ResultSet rs = sqlConn.getResults("bookings");
            while (rs.next()) {
                OneBooking oneBooking = new OneBooking(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),LocalDate.parse(rs.getString(6),formatter),RoomBookingFunctions.returnTimeFromString(rs.getString(7)));
                listOfBookings.add(oneBooking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        private void loadUnavailabilities() {
        try {
            ResultSet rs = sqlConn.getResults("unavailabilities");
            while (rs.next()) {
                OneUnavailability oneUnavailability = new OneUnavailability(rs.getString(1),LocalDate.parse(rs.getString(2), formatter), LocalDate.parse(rs.getString(3), formatter),rs.getString(4));
                listOfUnavailabilities.add(oneUnavailability);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public ArrayList<OneRoom> getTheRooms() {
        return listOfRooms;
    }

    public void addRoom(OneRoom newRoom) {
        listOfRooms.add(newRoom);
        setChanged();
        notifyObservers();
        sqlConn.addRoom(newRoom.getRoomName(), newRoom.getTypeOfRoom().toString(), newRoom.getSpaces());
    }

    public void removeRoom(String roomName) {
        for (int i = 0; i < listOfRooms.size(); i++) {
            OneRoom room = listOfRooms.get(i);
            if (room.getRoomName().equals(roomName)) {
                listOfRooms.remove(room);
            }
        }
        setChanged();
        notifyObservers();
        sqlConn.deleteRoom(roomName);
    }

    public ArrayList<OneBooking> getTheBookings() {
        return listOfBookings;
    }

    public void addBooking(OneBooking newBooking) {
        listOfBookings.add(newBooking);
        setChanged();
        notifyObservers();
        sqlConn.addBooking(newBooking.getRoomName(), newBooking.getBookerName(), newBooking.getBookerEmail(), newBooking.getBookerPhone(), newBooking.getBookingNotes(), newBooking.getBookingDate(), newBooking.getBookingTime().toString());
    }

    public void removeBooking(String roomName, LocalDate date, TimeOfDay time) {
        for (int i = 0; i < listOfBookings.size(); i++) {
            OneBooking booking = listOfBookings.get(i);
            if ((booking.getRoomName().equals(roomName)) && (booking.getBookingDate().isEqual(date)) && (booking.getBookingTime().equals(time))) {
                listOfBookings.remove(booking);
            }
        }
        setChanged();
        notifyObservers();
        sqlConn.deleteBooking(roomName, date, time);
    }

    public ArrayList<OneTerm> getTheTerms() {
        return listOfTerms;
    }

    public void addTerm(OneTerm newTerm) {
        listOfTerms.add(newTerm);
        setChanged();
        notifyObservers();
        sqlConn.addTerm(newTerm.getTermBeginning(), newTerm.getTermEnding());
    }

    public void removeTerm(LocalDate termBeginning, LocalDate termEnding) {
        for (int i = 0; i < listOfTerms.size(); i++) {
            OneTerm term = listOfTerms.get(i);
            if (term.getTermBeginning().isEqual(termBeginning) && (term.getTermEnding().isEqual(termEnding))) {
                listOfTerms.remove(term);
            }
        }
        setChanged();
        notifyObservers();
        sqlConn.deleteTerm(termBeginning, termEnding);
    }

    public ArrayList<OneUnavailability> getTheUnavailabilities() {
        return listOfUnavailabilities;
    }

    public void addUnavailability(OneUnavailability newUnavailability) {
        listOfUnavailabilities.add(newUnavailability);
        setChanged();
        notifyObservers();
        sqlConn.addUnavailability(newUnavailability.getRoomName(), newUnavailability.returnUnavailStart(), newUnavailability.returnUnavailEnd(), newUnavailability.returnReason());
    }

    public void removeUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd) {
        for (int i = 0; i < listOfUnavailabilities.size(); i++) {
            OneUnavailability unavailability = listOfUnavailabilities.get(i);
            if (unavailability.getRoomName().equals(roomName) && unavailability.returnUnavailStart().isEqual(unavailStart) && unavailability.returnUnavailEnd().isEqual(unavailEnd)) {
                listOfUnavailabilities.remove(unavailability);
            }
        }
        setChanged();
        notifyObservers();
        sqlConn.deleteUnavailability(roomName, unavailStart, unavailEnd);
    }

}
