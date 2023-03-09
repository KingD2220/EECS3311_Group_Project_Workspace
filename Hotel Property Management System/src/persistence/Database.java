package persistence;

import domain_objects_Rooms.*;
public interface Database {
	
	public boolean getUser(String userName, String passHash);
	public boolean addUser(String userName, String passHash);
	public Reservation getReservation(int resNum);
	public boolean addReservation(Reservation reservation);
	

}
