/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import DataStructures.TimeOfDay;
import DataStructures.OneUnavailability;
import DataStructures.OneRoom;
import DataStructures.OneTerm;
import DataStructures.OneBooking;
import DataStructures.TypeOfRoom;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;

public class SharedData extends Observable {

    private ArrayList<OneRoom> listOfRooms = new ArrayList<OneRoom>();
    private ArrayList<OneBooking> listOfBookings = new ArrayList<OneBooking>();
    private ArrayList<OneTerm> listOfTerms = new ArrayList<OneTerm>();
    private ArrayList<OneUnavailability> listOfUnavailabilities = new ArrayList<OneUnavailability>();
    SQLConnection sqlConn = new SQLConnection();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public SharedData() {
        super();
        //load data from tables into arraylists
        loadTerms();
        loadRooms();
        loadBookings();
        loadUnavailabilities();
    }

    private void loadTerms() {
        try {
            //get all results in terms table
            ResultSet rs = sqlConn.getResults("terms");
            //populate arraylist with results
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
            //get all results in room table
            ResultSet rs = sqlConn.getResults("rooms");
            //populate arraylist with results
            while (rs.next()) {
                String roomTypeStr = rs.getString(2);
                TypeOfRoom roomType = (roomTypeStr.equals("COMPUTER_LAB")) ? TypeOfRoom.COMPUTER_LAB : (roomTypeStr.equals("TUTORIAL_ROOM")) ? TypeOfRoom.TUTORIAL_ROOM : (roomTypeStr.equals("LECTURE_THEATRE")) ? TypeOfRoom.LECTURE_THEATRE : null;
                OneRoom oneRoom = new OneRoom(rs.getString(1), RoomBookingFunctions.returnRoomTypeFromString(roomTypeStr), rs.getInt(3));
                listOfRooms.add(oneRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBookings() {
        try {
            //get all results in bookings table
            ResultSet rs = sqlConn.getResults("bookings");
            //populate arraylist with results
            while (rs.next()) {
                OneBooking oneBooking = new OneBooking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), LocalDate.parse(rs.getString(6), formatter), RoomBookingFunctions.returnTimeFromString(rs.getString(7)));
                listOfBookings.add(oneBooking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUnavailabilities() {
        try {
            //get all results in unavailabilities table
            ResultSet rs = sqlConn.getResults("unavailabilities");
            //populate arraylist with results
            while (rs.next()) {
                OneUnavailability oneUnavailability = new OneUnavailability(rs.getString(1), LocalDate.parse(rs.getString(2), formatter), LocalDate.parse(rs.getString(3), formatter), rs.getString(4));
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
        //add to db
        sqlConn.addRoom(newRoom.getRoomName(), newRoom.getTypeOfRoom().toString(), newRoom.getSpaces());
    }

    public void removeRoom(String roomName) {
        //find matching room and remove from arraylist
        for (int i = 0; i < listOfRooms.size(); i++) {
            OneRoom room = listOfRooms.get(i);
            if (room.getRoomName().equals(roomName)) {
                listOfRooms.remove(room);
            }
        }
        setChanged();
        notifyObservers();
        //remove from db
        sqlConn.deleteRoom(roomName);
    }

    public ArrayList<OneBooking> getTheBookings() {
        return listOfBookings;
    }

    public void addBooking(OneBooking newBooking) {
        listOfBookings.add(newBooking);
        setChanged();
        notifyObservers();
        //add to db
        sqlConn.addBooking(newBooking.getRoomName(), newBooking.getBookerName(), newBooking.getBookerEmail(), newBooking.getBookerPhone(), newBooking.getBookingNotes(), newBooking.getBookingDate(), newBooking.getBookingTime().toString());
    }

    public void removeBooking(String roomName, LocalDate date, TimeOfDay time) {
        //find matching booking and remove from arraylist
        for (int i = 0; i < listOfBookings.size(); i++) {
            OneBooking booking = listOfBookings.get(i);
            if ((booking.getRoomName().equals(roomName)) && (booking.getBookingDate().isEqual(date)) && (booking.getBookingTime().equals(time))) {
                listOfBookings.remove(booking);
            }
        }
        setChanged();
        notifyObservers();
        //remove from db
        sqlConn.deleteBooking(roomName, date, time);
    }

    public ArrayList<OneTerm> getTheTerms() {
        return listOfTerms;
    }

    public void addTerm(OneTerm newTerm) {
        listOfTerms.add(newTerm);
        setChanged();
        notifyObservers();
        //add to db
        sqlConn.addTerm(newTerm.getTermBeginning(), newTerm.getTermEnding());
    }

    public void removeTerm(LocalDate termBeginning, LocalDate termEnding) {
        //find matching term and remove from arraylist
        for (int i = 0; i < listOfTerms.size(); i++) {
            OneTerm term = listOfTerms.get(i);
            if (term.getTermBeginning().isEqual(termBeginning) && (term.getTermEnding().isEqual(termEnding))) {
                listOfTerms.remove(term);
            }
        }
        setChanged();
        notifyObservers();
        //remove from db
        sqlConn.deleteTerm(termBeginning, termEnding);
    }

    public ArrayList<OneUnavailability> getTheUnavailabilities() {
        return listOfUnavailabilities;
    }

    public void addUnavailability(OneUnavailability newUnavailability) {
        listOfUnavailabilities.add(newUnavailability);
        setChanged();
        notifyObservers();
        //add to db
        sqlConn.addUnavailability(newUnavailability.getRoomName(), newUnavailability.returnUnavailStart(), newUnavailability.returnUnavailEnd(), newUnavailability.returnReason());
    }

    public void removeUnavailability(String roomName, LocalDate unavailStart, LocalDate unavailEnd) {
        //find matching unavailability and remove from arraylist
        for (int i = 0; i < listOfUnavailabilities.size(); i++) {
            OneUnavailability unavailability = listOfUnavailabilities.get(i);
            if (unavailability.getRoomName().equals(roomName) && unavailability.returnUnavailStart().isEqual(unavailStart) && unavailability.returnUnavailEnd().isEqual(unavailEnd)) {
                listOfUnavailabilities.remove(unavailability);
            }
        }
        setChanged();
        notifyObservers();
        //remove from db
        sqlConn.deleteUnavailability(roomName, unavailStart, unavailEnd);
    }

}
