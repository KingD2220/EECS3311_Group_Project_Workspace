package persistence;

import java.util.ArrayList;

import domain_objects_Rooms.Room;

public interface ManagementInterfaceDb {

	public ArrayList<Room> roomSearch (ArrayList<Room> rooms);
}
