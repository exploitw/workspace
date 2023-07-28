package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class OrderingDAO {
	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/C:/JAVA/H2/data/jwbookdb";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"sa","sa");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
					
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Book> getAll2(){
		open();
		List<Book> books = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select title,price FROM book");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				
				b.setTitle(rs.getString("title"));
				
				b.setPrice(rs.getInt("price"));
				
				
				books.add(b);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return books;
}
	
	public List<Customer> getAll1(){
		open();
		List<Customer> customers = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select name FROM customer");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer c = new Customer();
				
				c.setName(rs.getString("name"));
				
				
				customers.add(c);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return customers;
}
	public List<Ordering> getAll(){
		open();
		List<Ordering> orderings = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT customerId,bookid,sellingprice,orderingdate from ordering");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Ordering o = new Ordering();
				o.setCustomerId(rs.getInt("customerId"));
				o.setBookId(rs.getInt("bookID"));
				o.setSellingPrice(rs.getInt("sellingPrice"));
				o.setOrderingDate(rs.getString("orderingdate"));
				
				orderings.add(o);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}return orderings;
	}
	
	
	
}
