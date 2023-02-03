package domain_objects;

import java.util.Random;

public class Reservation {
	private int resNum;
	private Random rng = new Random();
	private String arrival_date = "";
	private String departure_date = "";
	Profile profile = new Profile();		// new instance of Profile class
	
	// constructor
	public Reservation(String last_name, String first_name, String address, String phone_num, String credit_card) {
		profile.setLast_name(last_name);
		profile.setFirst_name(first_name);
		profile.setAddress(address);
		profile.setPhone_num(phone_num);
		profile.setCredit_card(credit_card);
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
	
	public void changeDates(Reservation reservation, String newArrivalDate, String newDepartDate) {
		reservation.arrival_date = newArrivalDate;
		reservation.departure_date = newDepartDate;
	}

}
