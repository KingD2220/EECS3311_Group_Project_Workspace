package domain_objects;

public class Test {

	public static void main(String[] args) {
		Reservation newRes = new Reservation("Bond", "James", "69 Fake St., Toronto, Canada", "4165555555", "4512565678432394");
		
		System.out.println(newRes.profile.getFirst_name());
		System.out.println(newRes.profile.getAddress());
		System.out.println(newRes.profile.getCredit_card());
		System.out.println(newRes.getResNum());

	}
	
}
