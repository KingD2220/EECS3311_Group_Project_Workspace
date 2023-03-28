package persistence;

import java.util.ArrayList;

import domain_objects_Rooms.*;
import domain_objects_Users.Employee;
public interface Database {
	
	public boolean getUser(String userName, String passHash, String jobType);
	public boolean addUser(String userName, String passHash, String jobType);
	public Reservation getReservation(int resNum);
	public boolean addReservation(Reservation reservation);
	public boolean removeReservation(int resNum);
	public int getLastResNum();
	public boolean updateReservation(Reservation changedReservation);
	public ArrayList<Room> getRoomStatus(String roomNumStart, String roomNumEnd);
	public Employee getEmployee(String employeeNum);
	

}
