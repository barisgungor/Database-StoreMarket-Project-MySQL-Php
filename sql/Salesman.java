public class Salesman {
	private int sales_id; //autoincremented
	private String sales_name;
	private String sales_surname;
	private int branch_id; //foreign key
	
	public Salesman(int sales_id, String sales_name, String sales_surname,  int branch_id){ //for insert table
		this.sales_id = sales_id;
		this.sales_name = sales_name;
		this.sales_surname = sales_surname;
		this.branch_id = branch_id;
	}
	
	public Salesman(String sales_name, String sales_surname,  int branch_id){ //for create table
		
		this.sales_name = sales_name;
		this.sales_surname = sales_surname;
		this.branch_id = branch_id;
	}

	public int getSales_id() {
		return sales_id;
	}

	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}

	public String getSales_name() {
		return sales_name;
	}

	public void setSales_name(String sales_name) {
		this.sales_name = sales_name;
	}

	public String getSales_surname() {
		return sales_surname;
	}

	public void setSales_surname(String sales_surname) {
		this.sales_surname = sales_surname;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	

}
