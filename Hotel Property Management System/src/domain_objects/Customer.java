package domain_objects;

public class Customer extends Profile {
	protected String credit_card;
	protected int id;
	private static int totalCustomers = 1;
	
	
	public Customer() {
		super();
		this.id = totalCustomers++;
		
	}

	public String getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}
	
	

}
