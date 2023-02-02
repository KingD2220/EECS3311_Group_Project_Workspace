package domain_objects;

public class Profile {
	private String last_name = "";
	private String first_name = "";
	private String address = "";
	private String phone_num;
	private String credit_card;
	
	public Profile() {

	}
	
	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone_num() {
		return phone_num;
	}



	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}



	public String getCredit_card() {
		return credit_card;
	}



	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}
	
	
}
