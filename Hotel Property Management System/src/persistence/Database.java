package persistence;

import java.util.ArrayList;

import domain_objects_Rooms.*;
public interface Database {
	
	public boolean getUser(String userName, String passHash);
	public boolean addUser(String userName, String passHash);
	public Reservation getReservation(int resNum);
	public boolean addReservation(Reservation reservation);
	public boolean removeReservation(int resNum);
	public int getLastResNum();
	public boolean updateReservation(Reservation changedReservation);
	public ArrayList<Room> getRoomStatus(String roomNumStart, String roomNumEnd);
	

}
