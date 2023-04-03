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
	public void updateRoomStatus(String roomNum, String roomStatus);
	public Employee getEmployee(String employeeNum);
	public ArrayList<Reservation> getResByDate(String date, String caller);
	public boolean checkInReservation(int resNum, String roomNum);
}
