package persistence;

import java.util.ArrayList;
import java.util.List;

import domain_objects.Profile;
import domain_objects.Reservation;

public class DatabaseStubs {
	private static List<Profile> customers = new ArrayList<>();
	private static List<Reservation> reservations = new ArrayList<>();
	private static List<String> employee = new ArrayList<>();
	private static List<String> rooms = new ArrayList<>();
	
	public static List<Profile> getCustomers() {
		return customers;
	}
	public static List<Reservation> getReservations() {
		return reservations;
	}
	public static List<String> getEmployee() {
		return employee;
	}
	public static List<String> getRooms() {
		return rooms;
	}

}
