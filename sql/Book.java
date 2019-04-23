
public class Book {
	private int isbn;
	private String book_name;
	private int price;
	private int branch_id;
	
	public Book(int isbn, String book_name, int price, int branch_id){
		this.isbn = isbn;
		this.book_name = book_name;
		this.price = price;
		this.branch_id = branch_id;
		
	}
	
	public Book(String book_name, int price, int branch_id){
		
		this.book_name = book_name;
		this.price = price;
		this.branch_id = branch_id;
		
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
}
