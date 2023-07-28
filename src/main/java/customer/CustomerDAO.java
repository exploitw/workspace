package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import ch09.Student;

public class CustomerDAO {
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
	public List<Customer> getAll(){
		open();
		List<Customer> customers = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select id,name,address,phone FROM customer");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
				
				
				customers.add(c);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return customers;
}
	public void CustomerService() {
		//customerDao = new CustomerDAO();
	}
	/*
	public String Customer get(int id) {
		return customerDao.getCustomerById(id);
	}
	*/
	
	public void insert(Customer c) {
		open();
		String sql = "INSERT INTO customer(name,address,phone) values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public Customer get(int id) {
		List<Customer> customers = new ArrayList<>();
        Customer rtn = null;
        
        rtn = customers.get(id);
        
        if (rtn == null) {
            rtn = new Customer();
            rtn.setId(-1);
            rtn.setName("");
            rtn.setAddress("");
            rtn.setPhone("");
        }
        
        return rtn;
    }
	/*
	public synchronized void add(Customer customer) {
		int max = Collections.max(customers);
		customer.setId(max + 1);
		
		customers.add(customer.getId(),customer);
	}
	*/
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<>();
		return new ArrayList<>(customers);
	}
//	public Customer find(String id) {
//		return customers.get(id);
//	}
	 public synchronized void set(Customer customer) {
		 List<Customer> customers = new ArrayList<>();
	        customers.add(customer.getId(), customer);
	    }
	 public synchronized void remove(int id) {
		 List<Customer> customers = new ArrayList<>();
        customers.remove(id);
     }
	
	public void delete(int id) {
		int rtn = 0;
		open();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM customer where id =?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		
		
		
	}
}
