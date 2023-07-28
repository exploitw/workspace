package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
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
	
	public List<Book> getAll(){
		open();
		List<Book> books = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select id,title,publisher,price FROM book");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setPublisher(rs.getString("publisher"));
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
	
	public void insert(Book b) {
		open();
		String sql ="INSERT INTO book(title,publisher,price) values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getPrice());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
}
