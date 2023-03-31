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
    	
    	// if client request matches database, display room details on the frame
    	for (int i = 0; i < roomsList.size(); i++) {
    		Room room = roomsList.get(i);
    		String roomNum = room.getRoomNum();
    		String roomStatus = room.getRoomStatus();
    		String reservationStatus = room.getReservationStatus();
        	String lastRoomInput = "";
    		
    		if (this.dirty) {
    			if (roomStatus.equals("DIRTY")) {
    				rowValuesList.add(displayHelper(room));
    			}	
    		}
    		if (this.clean) {
    			if (roomStatus.equals("CLEAN")) {
    				rowValuesList.add(displayHelper(room));
    				lastRoomInput = roomNum;  			
    			}
    		}
    		if (this.inspected) {
    			if (roomStatus.equals("INSPECTED")) {
    				rowValuesList.add(displayHelper(room));
    				lastRoomInput = roomNum;
    			}
    		}
    		if (this.occupied) {
    			if ( reservationStatus.equals("OCCUPIED") && !roomNum.equals(lastRoomInput) ) {
    				rowValuesList.add(displayHelper(room));
    			}
    		}
    		if (this.vacant) {
    			if ( reservationStatus.equals("AVAILABLE") && !roomNum.equals(lastRoomInput) ) {
    				rowValuesList.add(displayHelper(room));
    			}
    		}
    	}
    	this.insertRows(rowValuesList);
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
    
    // Place all bucket elements of rowValuesList into an array to insert as a row in HousekeepingFrame 
    public void insertRows(ArrayList<ArrayList<Object>> list) {
    	Object[] rowArray = new Object[6];
    	if (list.size() != 0) {
    		for (int i = 0; i < list.size(); i++) {
    			for (int j = 0; j < rowArray.length; j++) {
    				rowArray[j] = list.get(i).get(j);
    			}
    			HousekeepingFrame.model.addRow(rowArray);
    		}
    	}
    	else {
    		HousekeepingFrame.model.setRowCount(0);
    	}
    }
    
    // update room status in database
    public void roomStatusUpdate(String roomNum, String roomStatus) {
    	managementLogic.roomStatusUpdate(roomNum, roomStatus);
    }
}
