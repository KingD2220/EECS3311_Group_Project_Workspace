package persistence;

import java.util.ArrayList;
import java.util.List;

public class DatabaseStubs {
	private static List<String> customers = new ArrayList<String>();
	private static List<String> reservations = new ArrayList<String>();
	private static List<String> employee = new ArrayList<String>();
	private static List<String> rooms = new ArrayList<String>();
	
	public static List<String> getCustomers() {
		return customers;
	}
	public static List<String> getReservations() {
		return reservations;
	}
	public static List<String> getEmployee() {
		return employee;
	}
	public static List<String> getRooms() {
		return rooms;
	}

}
