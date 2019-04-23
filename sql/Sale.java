
public class Sale {
	private int sale_id; //autoincremented
	private int customer_id; //foreign key 
	private int salesman_id; //foreign key 
	private int isbn; //foreign key
	private String date;
	public Sale(int sale_id, int customer_id, int salesman_id, int isbn, String date){ 
		this.sale_id = sale_id;
		this.customer_id = customer_id;
		this.salesman_id = salesman_id;
		this.isbn = isbn;
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Sale(int customer_id, int salesman_id, int isbn, String date){ 
		
		this.customer_id = customer_id;
		this.salesman_id = salesman_id;
		this.isbn = isbn;
		this.date = date;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getSalesman_id() {
		return salesman_id;
	}

	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
}
