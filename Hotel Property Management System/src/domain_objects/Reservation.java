package domain_objects;

import java.util.ArrayList;

public class Reservation {
	private static ArrayList<Reservation> reservationList = new ArrayList<>(); //List of reservations
	
	public String arrival_date = "";
	public String departure_date = "";
	public Customer customer = new Customer();
	
	private Room room;
	
	public Reservation(String last_name, String first_name, String address, String phone_num, String credit_card) {
		customer.setLast_name(last_name);
		customer.setFirst_name(first_name);
		customer.setAddress(address);
		customer.setPhone_num(phone_num);
		customer.setCredit_card(credit_card);
	}

	public String getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public static ArrayList<Reservation> getList() {
		return reservationList;
	}
}