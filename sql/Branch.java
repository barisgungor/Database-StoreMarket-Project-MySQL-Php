
public class Branch {
	private int branch_id; //autoincremented
	private String branch_name;
	private int prov_id; //foreign key provinces
	
	public Branch(String branch_name, int prov_id){ //insert
		
		this.branch_name = branch_name;
		this.prov_id = prov_id;
		
		
	}
	
	
	public Branch(int branch_id, String branch_name, int prov_id){ //create
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.prov_id = prov_id;
		
		
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}


	public int getProv_id() {
		return prov_id;
	}


	public void setProv_id(int prov_id) {
		this.prov_id = prov_id;
	}



}
