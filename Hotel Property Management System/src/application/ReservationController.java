package application;

import business_logic.SearchingLogic;
import domain_objects.Reservation;

/**
 * ReservationController should only be used to take information from front-end and
 * be the middleman for the model/database;
 * should not be changing what the GUI does or looks like.
 */

public class ReservationController {

	public ReservationController() {
		super();	// FIX ME: why we calling super()?
	}
	
	/**
	 * search method takes in reservation # and calls SearchingLogic class;
	 * returns reservation associated with res #. 
	 */
	public Reservation search(String resNum) {
		System.out.println(resNum);
		Reservation newRes = SearchingLogic.searchByResNum(Integer.parseInt(resNum));
		return newRes;
	  
	}
	
	/**
	 * update method takes in all variables from UpdateFrame w/ or w/o changes and 
	 * updates the reservation.
	 */
	public Reservation update(String resNum, String fName, String lName, String phoneNum, String address) {
		Reservation newRes = SearchingLogic.searchByResNum(Integer.parseInt(resNum));
		newRes.customer.setFirst_name(fName);
		newRes.customer.setLast_name(lName);
		newRes.customer.setPhone_num(phoneNum);
		newRes.customer.setAddress(address);
		return newRes;
	
	}
		
	
}
