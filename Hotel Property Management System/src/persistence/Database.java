package persistence;

import domain_objects.Account;
import domain_objects_Rooms.*;
public interface Database {
	
	public boolean getUser(String userName, byte[] passHash);
	public boolean addUser(String userName, byte[] passHash);
	public int numOfReservations();
	public Reservation getReservation(int resNum);
	public boolean addReservation(Reservation reservation);
	

}
