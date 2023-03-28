package business_logic;

import java.util.ArrayList;
import domain_objects_Rooms.Room;
import persistence.Database;

public class ManagementLogic {
	private final Database database;
	
	public ManagementLogic(Database database) {
		this.database = database;
	}
	
	// get range of rooms selected by the caller with specifications, if selected.
	public ArrayList<Room> roomSearch(String roomRangeStart, String roomRangeEnd) {
		return database.getRoomStatus(roomRangeStart, roomRangeEnd);
	}
	
}
