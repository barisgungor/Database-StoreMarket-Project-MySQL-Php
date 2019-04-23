import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class Button extends JFrame implements ActionListener {
	public static Connection c;
	
	public static ArrayList<Branch> BranchList = new ArrayList<Branch>();
	public static ArrayList<Salesman> SamList = new ArrayList<Salesman>();
	public static ArrayList<Customer> CustList = new ArrayList<Customer>();
	public static ArrayList<Provinces> ProvList = new ArrayList<Provinces>();
	public static ArrayList<Book> BookList = new ArrayList<Book>();
	public static ArrayList<Sale> SaList = new ArrayList<Sale>();
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project"; //deðiþtir
	static final int DEMO_DEPT_ID=10;

	// Database credentials
	static final String USER = "root";
	static final String PASS = "mysql";
	
	static File branch = new File("branch.txt");
	static File salesman = new File("salesman.txt");
	static File customer = new File("customer.txt");
	static File provinces = new File("provinces.txt");
	static File book = new File("book.txt");
	static File sale = new File("sale.txt");
	
		private enum Actions {
	    CT, //Create Table
	    IN,	//Insert Table
	  
	  }
	
	/*private int button_loc_x=100;
	private int button_loc_y=250;
	private int button_size_x=120;
	private int button_size_y=35;*/
	
	
	JFrame frame = new JFrame("Create/Insert");
	
	JButton CT = new JButton("Create Table");
	JButton IN = new JButton("Insert Table");
	
	Panel pa= new Panel();
	public Button(){
		
		frame.setLayout(new GridLayout());
		frame.setSize(500, 400);
		frame.setResizable(true);
		
		CT.setActionCommand(Actions.CT.name());
		CT.addActionListener(this);
		//CT.setBounds(button_loc_x+90, button_loc_y, button_size_x, button_size_y);
		frame.add(CT);
		
		IN.setActionCommand(Actions.IN.name());
		IN.addActionListener(this);
		//IN.setBounds(button_loc_x+90, button_loc_y+150, button_size_x, button_size_y);
		frame.add(IN);
		
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
			
			new Button().setVisible(false);
			}
		});

	}
	
	public static void baglantiAc(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			
		}catch (Exception e) {
			
		}
	}
		
	public static void baglantiKapat(){
		try {
			
			c.close();
			
		}catch (Exception e) {
			
		}
	}
	public static void create_prov(){
		baglantiAc();
		
		try {
			
			c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("create fonk girdim ");
			
			java.sql.Statement stmt = c.createStatement();
			
			String ins ="DROP TABLE Provinces;";
			 stmt.executeUpdate(ins);
			
			 //stmt = (PreparedStatement) c.prepareStatement(ins);
				
			
			 String ins1 ="CREATE TABLE Provinces"+ 
						"(prov_id INT(11) NOT NULL auto_increment, "
						+ "city varchar(60) default NULL, " +
				"district varchar(60) default NULL, "+
						"PRIMARY KEY (prov_id));";
			 stmt.executeUpdate(ins1);
				stmt.close();
				System.out.println("create fonk cýktým5588 ");
				//bag.close();
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		baglantiKapat();
	}
	

	public static void insert_prov(){
		if(!provinces.exists()){
			System.out.println("Kullanici Bilgileri File Eksik.");
		}else{
			try {
				Scanner sc = new Scanner(provinces);
				
				while(sc.hasNext()){
					String[] kb = sc.nextLine().split("-");
					
					
					Provinces b =new Provinces(kb[0], kb[1]);
					
					ProvList.add(b);
								
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		baglantiAc();
		
		
		try {
			String ins = "INSERT INTO Provinces(city, district)" + "VALUES (?,?);";
			PreparedStatement stmt = (PreparedStatement) c.prepareStatement(ins);	
				
			
			stmt = (PreparedStatement) c.prepareStatement(ins);
			for(int j=0; j<ProvList.size(); j++){
			stmt.setString(1, ProvList.get(j).getCity());
			stmt.setString(2, ProvList.get(j).getDistrict());
			int result = stmt.executeUpdate();
			}
			
			System.out.println("çýktým");
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
		System.out.println("çýktýýým");
	}
	public static void create_branch(){
		baglantiAc();
		try {
		//Class.forName("com.mysql.jdbc.Driver");
		//String bagMetni =  "jdbc:mysql://localhost:3306/project";
		//Connection bag = (Connection) DriverManager.getConnection(bagMetni);
		c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("create fonk girdim ");
		//Statement stmt = (Statement) c.createStatement();
		java.sql.Statement stmt = c.createStatement();
		String ins ="DROP TABLE Branch;";
		
		
		stmt.executeUpdate(ins);
			//stmt = (PreparedStatement) c.prepareStatement(ins);
			//ResultSet result = stmt.executeQuery(ins);
		
		 String ins1= "CREATE TABLE Branch" +
			"(branch_id INT(11) NOT NULL auto_increment," +
			"branch_name varchar(60) default NULL, "+
			"PRIMARY KEY (branch_id), "+
					"prov_id INT(11) default NULL), "
		+"FOREIGN KEY (prov_id) references Provinces(prov_id));";
		 stmt.executeUpdate(ins1);
			stmt.close();
			//bag.close();
		} catch (Exception e) {
			System.out.println("create fonk cýktým ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
		
	}
	
	public static void insert_branch(){
		if(!branch.exists()){
			System.out.println("Kullanici Bilgileri File Eksik.");
		}else{
			try {
				Scanner sc = new Scanner(branch);
				
				while(sc.hasNext()){
					String[] kb = sc.nextLine().split("-");
					
					int y = Integer.parseInt(kb[1].toString());
					System.out.println(y);
					Branch b =new Branch(kb[0], y);
					
					BranchList.add(b);
								
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		baglantiAc();
		
		
		try {
			String ins = "INSERT INTO Branch(branch_name, prov_id)" + "VALUES (?,?);";
			PreparedStatement stmt = (PreparedStatement) c.prepareStatement(ins);	
				
			
			stmt = (PreparedStatement) c.prepareStatement(ins);
			for(int j=0; j<BranchList.size(); j++){
			stmt.setString(1, BranchList.get(j).getBranch_name());
			stmt.setInt(2, BranchList.get(j).getProv_id());
			int result = stmt.executeUpdate();
			}
			
			System.out.println("çýktým");
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
		System.out.println("çýktýýým");
	}
	

	
	public static void create_salesman(){
		baglantiAc();
		try {
		//Class.forName("com.mysql.jdbc.Driver");
		//String bagMetni =  "jdbc:mysql://localhost:3306/project";
		//Connection bag = (Connection) DriverManager.getConnection(bagMetni);
		c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("create fonk girdim ");
		//Statement stmt = (Statement) c.createStatement();
		java.sql.Statement stmt = c.createStatement();
		
		String ins ="DROP TABLE Salesman;";
		 stmt.executeUpdate(ins);
		
		 //stmt = (PreparedStatement) c.prepareStatement(ins);
			//ResultSet result = stmt.executeQuery(ins);
		
		 String ins1 = "CREATE TABLE Salesman"+
					"(sales_id INT(11) NOT NULL auto_increment, "+
							"sales_name varchar(60) default NULL, "+
					"sales_surname varchar(60) default NULL, "+ "branch_id INT(11) NOT NULL, "+
							"PRIMARY KEY (sales_id), "+
					"FOREIGN KEY (branch_id) references Branch(branch_id));";
		 stmt.executeUpdate(ins1);
			stmt.close();
			System.out.println("create fonk cýktým5588 ");
			//bag.close();
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
		
	}
	public static void insert_salesman(){
		if(!salesman.exists()){
			System.out.println("Kullanici Bilgileri File Eksik.");
		}else{
			try {
				Scanner sc = new Scanner(salesman);
				
				while(sc.hasNext()){
					String[] kb = sc.nextLine().split("-");
					
					int y = Integer.parseInt(kb[2].toString());
					System.out.println(y);
					Salesman s =new Salesman(kb[0], kb[1], y);
					
					SamList.add(s);
								
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		baglantiAc();

		
		try {
			String ins = "INSERT INTO Salesman(sales_name, sales_surname, branch_id)" + "VALUES (?,?,?);";
			PreparedStatement stmt = (PreparedStatement) c.prepareStatement(ins);
			stmt = (PreparedStatement) c.prepareStatement(ins);
			
			for(int j=0; j<SamList.size(); j++){
			stmt.setString(1, SamList.get(j).getSales_name());
			stmt.setString(2, SamList.get(j).getSales_surname());
			stmt.setInt(3, SamList.get(j).getBranch_id());
		
			int result = stmt.executeUpdate();
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
	}
	
	public static void create_customer(){
		baglantiAc();
		
		try {
			
			c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("create fonk girdim ");
			
			java.sql.Statement stmt = c.createStatement();
			
			String ins ="DROP TABLE Customer;";
			stmt.executeUpdate(ins);
			
			
			 String ins1 ="CREATE TABLE Customer"+ 
						"(cust_id INT(11) NOT NULL auto_increment, "
						+ "customer_name varchar(60) default NULL, " +
				"customer_surname varchar(60) default NULL, "+ "branch_id INT(11) NOT NULL, "+
				"PRIMARY KEY (cust_id), "+
						"FOREIGN KEY (branch_id) references Branch(branch_id));";
			 
			 stmt.executeUpdate(ins1);
				stmt.close();
				System.out.println("create fonk cýktým5588 ");
				//bag.close();
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		baglantiKapat();
	}
	
	
	public static void insert_customer(){
		if(!customer.exists()){
			System.out.println("Kullanici Bilgileri File Eksik.");
		}else{
			try {
				Scanner sc = new Scanner(customer);
				
				while(sc.hasNext()){
					String[] kb = sc.nextLine().split("-");
					
					int y = Integer.parseInt(kb[2].toString());
					System.out.println(y);
					Customer c =new Customer(kb[0], kb[1], y);
					
					CustList.add(c);
								
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		baglantiAc();

		
		try {
			String ins = "INSERT INTO Customer(customer_name, customer_surname, branch_id)" + "VALUES (?,?,?);";
			PreparedStatement stmt = (PreparedStatement) c.prepareStatement(ins);
			stmt = (PreparedStatement) c.prepareStatement(ins);
			
			for(int j=0; j<CustList.size(); j++){
			stmt.setString(1, CustList.get(j).getCustomer_name());
			stmt.setString(2, CustList.get(j).getCustomer_surname());
			stmt.setInt(3, CustList.get(j).getBranch_id());
		
			int result = stmt.executeUpdate();
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
	}
	public static void create_book(){
		baglantiAc();
		
		try {
			
			c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("create fonk girdim ");
			
			java.sql.Statement stmt = c.createStatement();
			
			String ins ="DROP TABLE Book;";
			 stmt.executeUpdate(ins);
			
			
			 String ins1 ="CREATE TABLE Book"+ 
						"(isbn INT(11) NOT NULL auto_increment, "
						+ "book_name varchar(60) default NULL, " +
				"price INT(11) NOT NULL, "+ "branch_id INT(11) NOT NULL, "+
				"PRIMARY KEY (isbn), "+
						"FOREIGN KEY (branch_id) references Branch(branch_id));";
			 
			 stmt.executeUpdate(ins1);
				stmt.close();
				System.out.println("create fonk cýktým5588 ");
				//bag.close();
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		baglantiKapat();
	}
	public static void insert_book(){
		if(!book.exists()){
			System.out.println("Kullanici Bilgileri File Eksik.");
		}else{
			try {
				Scanner sc = new Scanner(book);
				
				while(sc.hasNext()){
					String[] kb = sc.nextLine().split("-");
					int x = Integer.parseInt(kb[1].toString());
					int y = Integer.parseInt(kb[2].toString());
					System.out.println(y);
					Book b =new Book(kb[0], x, y);
					
					BookList.add(b);
								
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		baglantiAc();

		
		try {
			String ins = "INSERT INTO Book(book_name, price, branch_id)" + "VALUES (?,?,?);";
			PreparedStatement stmt = (PreparedStatement) c.prepareStatement(ins);
			stmt = (PreparedStatement) c.prepareStatement(ins);
			
			for(int j=0; j<BookList.size(); j++){
			stmt.setString(1, BookList.get(j).getBook_name());
			stmt.setInt(2, BookList.get(j).getPrice());
			stmt.setInt(3, BookList.get(j).getBranch_id());
		
			int result = stmt.executeUpdate();
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
	}
	public static void create_sale(){
		baglantiAc();
		
		try {
			
			c = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("create fonk girdim ");
			
			java.sql.Statement stmt = c.createStatement();
			
			String ins ="DROP TABLE Sale;";
			 stmt.executeUpdate(ins);
			
			
			 String ins1 ="CREATE TABLE Sale"+ 
						"(sale_id INT(11) NOT NULL auto_increment, "
						+ "customer_id INT(11) NOT NULL, " +
				"salesman_id INT(11) NOT NULL, "+ "isbn INT(11) NOT NULL, "+
						"date DATE NOT NULL, "+
				"PRIMARY KEY (sale_id), " +
						"FOREIGN KEY (customer_id) references Customer(cust_id), " + 
				"FOREIGN KEY (salesman_id) references Salesman(sales_id), "+
						"FOREIGN KEY (isbn) references Book(isbn));";
			 
			 stmt.executeUpdate(ins1);
				stmt.close();
				System.out.println("create fonk cýktým5588 ");
				//bag.close();
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		baglantiKapat();
	}
	public static void insert_sale(){
		if(!sale.exists()){
			System.out.println("Kullanici Bilgileri File Eksik.");
		}else{
			try {
				Scanner sc = new Scanner(sale);
				
				while(sc.hasNext()){
					String[] kb = sc.nextLine().split("-");
					
					int x = Integer.parseInt(kb[0].toString());
					int y = Integer.parseInt(kb[1].toString());
					int z = Integer.parseInt(kb[2].toString());
					
					System.out.println(y);
					Sale b =new Sale(x, y, z, kb[3]);
					
					SaList.add(b);
								
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		baglantiAc();

		
		try {
			String ins = "INSERT INTO Sale(customer_id, salesman_id, isbn, date)" + "VALUES (?,?,?, STR_TO_DATE(?, '%d/%m/%Y'));";
			PreparedStatement stmt = (PreparedStatement) c.prepareStatement(ins);
			stmt = (PreparedStatement) c.prepareStatement(ins);
			
			for(int j=0; j<SaList.size(); j++){
			stmt.setInt(1, SaList.get(j).getCustomer_id());
			stmt.setInt(2, SaList.get(j).getSalesman_id());
			stmt.setInt(3, SaList.get(j).getIsbn());
			stmt.setString(4, SaList.get(j).getDate());
		
			int result = stmt.executeUpdate();
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baglantiKapat();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == Actions.CT.name()){
		//frame.setVisible(false);
		JOptionPane.showMessageDialog(this, "Create succesfully!");
		
		
			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
				
				protected Void doInBackground() throws Exception {
					create_prov();
					create_branch();
					create_salesman();
					create_customer();
					create_book();
					create_sale();
					return null;
				}
				
			};
			worker.execute();
			
		}
			//insert_branch();	
				
				
		
		for(int i=0; i<BranchList.size(); i++){
			System.out.println(BranchList.get(i).getBranch_name() +" "+ BranchList.get(i).getProv_id());
		
		}
		if(e.getActionCommand() == Actions.IN.name()){
			//frame.setVisible(false);
			
				
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
					
					protected Void doInBackground() throws Exception {
						insert_prov();
						insert_branch();
						insert_salesman();
						insert_customer();
						insert_book();
						insert_sale();
						return null;
					}
					
				};
				worker.execute();
				
				
				
				
				
				
			JOptionPane.showMessageDialog(this, "Insert succesfully!");
			
			
		}
		
	}


	

}
