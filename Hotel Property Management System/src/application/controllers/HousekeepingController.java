package application.controllers;

import java.util.ArrayList;

import application.frames.HousekeepingFrame;
import business_logic.ManagementLogic;
import domain_objects_Rooms.Room;
import persistence.RealDatabase;

public class HousekeepingController {	
    ManagementLogic managementLogic = new ManagementLogic(new RealDatabase());
    String rangeStart;
    String rangeEnd;
    boolean dirty;
    boolean clean;
    boolean inspected;
    boolean occupied;
    boolean vacant;
        
    public HousekeepingController(String rangeStart, String rangeEnd, boolean dirty, boolean clean, boolean inspected, boolean occupied, boolean vacant) {
    	this.rangeStart = rangeStart;
    	this.rangeEnd = rangeEnd;
    	this.dirty = dirty;
    	this.clean = clean;
    	this.inspected = inspected;
    	this.occupied = occupied;
    	this.vacant = vacant;
    }
       
    /**
     * Get room details following the structure {"Room Number", "Room Status", "Room Type", "Reserv. Status", "Arrival Date", "Departure Date"},
     * then update HousekeepingFrame rooms display.
     */
    public void displayRoomDetails() {
    	ArrayList<Room> roomsList = managementLogic.roomSearch(rangeStart, rangeEnd);	// get array of rooms that was searched
    	ArrayList<ArrayList<Object>> rowValuesList = new ArrayList<ArrayList<Object>>();
    	Object[] rowArray = new Object[6];
    	String lastRoomInput = "";
    	
    	// Loop through the list of rooms requested and place in a list only the rooms with the room status and reservation 
    	// status that were selected by the client.
    	for (int i = 0; i < roomsList.size(); i++) {
    		if (this.dirty) {
    			if (roomsList.get(i).getRoomStatus().equals("DIRTY")) {
    				rowValuesList.add(displayHelper(roomsList.get(i)));
    			}	
    		}
    		if (this.clean) {
    			if (roomsList.get(i).getRoomStatus().equals("CLEAN")) {
    				rowValuesList.add(displayHelper(roomsList.get(i)));
    				lastRoomInput = roomsList.get(i).getRoomNum();   			
    			}
    		}
    		if (this.inspected) {
    			if (roomsList.get(i).getRoomStatus().equals("INSPECTED")) {
    				rowValuesList.add(displayHelper(roomsList.get(i)));
    				lastRoomInput = roomsList.get(i).getRoomNum();
    			}
    		}
    		if (this.occupied) {
    			if ( roomsList.get(i).getReservationStatus().equals("OCCUPIED") && !roomsList.get(i).getRoomNum().equals(lastRoomInput) ) {
    				rowValuesList.add(displayHelper(roomsList.get(i)));
    			}
    		}
    		if (this.vacant) {
    			if ( roomsList.get(i).getReservationStatus().equals("AVAILABLE") && !roomsList.get(i).getRoomNum().equals(lastRoomInput) ) {
    				rowValuesList.add(displayHelper(roomsList.get(i)));
    			}
    		}
    	}
    	
    	// Place all bucket elements of rowValuesList into an array to insert as a row in HousekeepingFrame 
    	for (int i = 0; i < rowValuesList.size(); i++) {
    		for (int j = 0; j < rowArray.length; j++) {
    			rowArray[j] = rowValuesList.get(i).get(j);
    		}
        	HousekeepingFrame.model.addRow(rowArray);
    	}
    }
    
  
    // displayRoomsDetail() helper method
    public ArrayList<Object> displayHelper(Room room) {
    	ArrayList<Object> objArray = new ArrayList<>();
    	objArray.add(room.getRoomNum());
    	objArray.add(room.getRoomStatus());
    	objArray.add(room.getRoomType());
    	objArray.add(room.getReservationStatus());
    	objArray.add(room.getArrivalDate());
    	objArray.add(room.getDepartureDate());
    	return objArray;
    }
    
    public void roomStatusUpdate(String roomNum, String roomStatus) {
    	managementLogic.roomStatusUpdate(roomNum, roomStatus);
    }
}
