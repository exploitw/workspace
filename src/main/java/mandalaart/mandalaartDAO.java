package mandalaart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch09.Student;

public class mandalaartDAO {
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
	
	
	public List<MandalaartDO> getAll(){
		open();
		List<MandalaartDO> mandalaarts = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select semi_goal FROM semimandalaart");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MandalaartDO m = new MandalaartDO();
				m.setSemi_goal(rs.getString("semi_goal"));
				
				mandalaarts.add(m);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return mandalaarts;
	
}
	public List<MandalaartDO> getAll2(){
		open();
		List<MandalaartDO> mandalaarts2 = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select detail_goal from detailmandalaart where semi_id =?");
			ResultSet rs2 = pstmt.executeQuery();
			
			while(rs2.next()) {
				MandalaartDO mm = new MandalaartDO();
				mm.setDetail_goal(rs2.getString("detail_goal"));
				
				mandalaarts2.add(mm);
			}
			rs2.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}return mandalaarts2;
	}
	
	
	
}
