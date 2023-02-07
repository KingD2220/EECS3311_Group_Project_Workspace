package domain_objects;

import java.util.Random;

public class Reservation {
	private int resNum;
	private Random rng = new Random();
	private String arrival_date = "";
	private String departure_date = "";
	private int roomNumber;		// foreign id
	Customer customer = new Customer();		// new instance of customer class
	
	// constructor
	public Reservation(String last_name, String first_name, String address, String phone_num, String credit_card) {
		customer.setLast_name(last_name);
		customer.setFirst_name(first_name);
		customer.setAddress(address);
		customer.setPhone_num(phone_num);
		customer.setCredit_card(credit_card);
		resNum = (rng.nextInt(1000000));
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
	
	public int getResNum() {
		return resNum;
	}
	

}
