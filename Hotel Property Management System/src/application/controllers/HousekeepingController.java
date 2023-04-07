package application.controllers;

import java.util.ArrayList;

import application.frames.HousekeepingFrame;
import business_logic.ManagementLogic;
import domain_objects_Rooms.Room;
import persistence.RealDatabase;

public class HousekeepingController {	
    ManagementLogic managementLogic = new ManagementLogic(RealDatabase.getInstance());
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
    		String lastRoomInput = "";
        	
    		if (this.dirty && roomStatus.equals("DIRTY")) {
    			rowValuesList.add(displayHelper(room));
    			lastRoomInput = roomNum;
    		}
    		if (this.clean && roomStatus.equals("CLEAN")) {
    			rowValuesList.add(displayHelper(room));
    			lastRoomInput = roomNum;
    		}
    		if (this.inspected && roomStatus.equals("INSPECTED")) {
    			rowValuesList.add(displayHelper(room)); 
    			lastRoomInput = roomNum;
    		}
    		if (isOccupiedMatching(room) && !roomNum.equals(lastRoomInput)) {
    			rowValuesList.add(displayHelper(room)); 
    		}
    		if (isVacantMatching(room) && !roomNum.equals(lastRoomInput)) {
    			rowValuesList.add(displayHelper(room));
    		}
    	}
    	this.insertRows(rowValuesList);
    }	
    
    // displayRoomsDetail() helper method
    private ArrayList<Object> displayHelper(Room room) {
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
    private void insertRows(ArrayList<ArrayList<Object>> list) {
    	Object[] rowArray = new Object[6];
    	if (!list.isEmpty()) {
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
    
    //checks if reservation status "OCCUPIED" matches user selection
    private boolean isOccupiedMatching(Room room) {
    	if (this.occupied && room.getReservationStatus().equals("OCCUPIED")) {
    		return true;
    	} else {
    		return false;
    	}	
    }
    
    //checks if reseration status "AVAILABLE" matches user selection
    private boolean isVacantMatching(Room room) {
    	if (this.vacant && room.getReservationStatus().equals("AVAILABLE")) {
    		return true;
    	} else {
    		return false;
    	}
    }	
    
    //update room status in database
    public void roomStatusUpdate(String roomNum, String roomStatus) {
    	managementLogic.roomStatusUpdate(roomNum, roomStatus);
    }
    
    //search available rooms for check-in based on room type
    public String[] getAvailableRooms(String roomType) {
    	ArrayList<Room> roomsList = managementLogic.roomSearch(rangeStart, rangeEnd);	// get array of rooms that was searched
    	ArrayList<String> roomsAvail = new ArrayList<>();
    	for (int i = 0; i < roomsList.size(); i++) {
    		Room room = roomsList.get(i);
    		if (room.getRoomType().equals(roomType) && room.getRoomStatus().equals("INSPECTED") && room.getReservationStatus().equals("AVAILABLE")) {
    			roomsAvail.add(room.getRoomNum());
    		}
    	}
    	String[] rooms = new String[roomsAvail.size()];
    	for (int j = 0; j < rooms.length; j++) {
    		rooms[j] = roomsAvail.get(j);
    	}    	
    	return rooms;
    }
}
