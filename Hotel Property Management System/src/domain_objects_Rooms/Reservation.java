package domain_objects_Rooms;

import domain_objects_Users.Customer;

public class Reservation {
	
	public String arrival_date = "";
	public String departure_date = "";
	public Customer customer = new Customer();
	private int resNumber;
	

	private Room room;
	
	public Reservation(String first_name, String last_name, String address, String phone_num, String credit_card) {
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
	@Override
	public String toString() {
		return "  Reservation arrival_date:" + arrival_date +  "\n" + "  Departure_date:" + departure_date + "\n" +"  Customer="
				+ customer + "\n" + "  RoomType:" + "\n" + "  Reservation Number:" + resNumber  ;
	}

	public int getResNumber() {
		return resNumber;
	}

	public void setResNumber(int resNumber) {
		this.resNumber = resNumber;
	}
}