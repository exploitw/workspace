package mandalaart2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mandalaart.MandalaartDO;

public class MandalaartDAO {
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
	
	
	public String getFirstGoal(){
		String rtn = null;
		open();
		
		
		try {
			pstmt = conn.prepareStatement("SELECT name FROM first_goal WHERE id =1");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				rtn = rs.getString("name");
			}
			
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return rtn;
	
}
	public List<String> getSecondGoals(){
		List<String> rtn = new ArrayList<>();
		open();
		
		
		try {
			pstmt = conn.prepareStatement("SELECT name FROM second_goal where firstId = 1");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				rtn.add(name);
			}
			
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return rtn;
	
}
	
	public int getSecondIdByName(String name){
		int rtn = 0;
		open();
		
		
		try {
			pstmt = conn.prepareStatement("SELECT id FROM second_goal where name =?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				rtn = rs.getInt("id");
			}
			
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return rtn;
	
}
	
	public List<String> getThirdGoalsBySecondId(int secondId){
		List<String> rtn = new ArrayList<>();
		open();
		
		
		try {
			pstmt = conn.prepareStatement("SELECT name FROM third_goal where secondId = ?");
			pstmt.setInt(1, secondId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				rtn.add(name);
			}
			
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return rtn;
	
}
	
	
	
}

