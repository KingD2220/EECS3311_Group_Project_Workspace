package persistence;

import java.util.ArrayList;

import domain_objects_Rooms.Room;

public interface ManagementInterfaceDb {

	public ArrayList<Room> getRoomStatus(String roomNumStart, String roomNumEnd);
}
