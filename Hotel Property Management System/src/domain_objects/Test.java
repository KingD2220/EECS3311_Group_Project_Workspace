package domain_objects;

import java.io.PrintStream;

public class Test {

	public static void main(String[] args) {
		PrintStream out = System.out;
		
		Reservation res = new Reservation("Bond", "James", "69 Fake St., Toronto, Canada", "4165555555", "4512565678432394");
		
		res.setArrival_date("2023-02-03");
		res.setDeparture_date("2023-02-05");	
		
		out.println("Cx Profile Info:");
		out.print(res.profile.getFirst_name()); 
		out.println(" " + res.profile.getLast_name());
		out.println(res.profile.getAddress());
		out.println("Credit card number: " + res.profile.getCredit_card());
		out.println("Reserv. number: " + res.getResNum()); out.println();
		
		out.println("Old Reservation Dates");
		out.println(res.getArrival_date());
		out.println(res.getDeparture_date()); out.println();
		
		res.changeDates(res, "2022-02-20", "2022-02-24");


		out.println("New Reservation Dates:");
		out.println(res.getArrival_date());
		out.println(res.getDeparture_date());

	}
	
}
