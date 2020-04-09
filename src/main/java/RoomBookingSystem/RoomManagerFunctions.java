/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomBookingSystem;

import java.util.ArrayList;

public class RoomManagerFunctions {

    //checks if room name is unique
    public static boolean isRoomNameUnique(ArrayList<OneRoom> rooms, String roomName) {
        //iterate through rooms and find if any other rooms have same name
        for (OneRoom room : rooms) {
            if (roomName.equals(room.getRoomName())) {
                return false;
            }
        }
        return true;
    }

    //return OneRoom from name
    public static OneRoom getRoomFromName(ArrayList<OneRoom> rooms, String name) {
        //iterate through rooms and return the one that matches name
        for (OneRoom room : rooms) {
            if (room.getRoomName().equals(name)) {
                return room;
            }
        }
        return null;
    }
}
