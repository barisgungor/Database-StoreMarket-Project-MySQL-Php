public class Customer {
	private int cust_id; //autoincremented
	private String customer_name;
	private String customer_surname;
	private int branch_id; //foreign key
	
	public Customer(int cust_id, String customer_name, String customer_surname,  int branch_id){ //for insert table
		this.cust_id = cust_id;
		this.customer_name = customer_name;
		this.customer_surname = customer_surname;
		this.branch_id = branch_id;
	
	}
	
	public Customer(String customer_name, String customer_surname,  int branch_id){ //for creates table
		
		this.customer_name = customer_name;
		this.customer_surname = customer_surname;
		this.branch_id = branch_id;
	
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_surname() {
		return customer_surname;
	}

	public void setCustomer_surname(String customer_surname) {
		this.customer_surname = customer_surname;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

}
