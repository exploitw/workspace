package ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NewsDAO {
	protected DataSource dataSource;
	
	public NewsDAO() {
		super();
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/jwbookdb");
		}catch(NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	public void addNews(News n) throws Exception{
		String sql = "INSERT INTO news(title,img,date,content) values(?,?,CURRENT_TIMESTAMP(),?)";
		
		try(Connection c = dataSource.getConnection();
				 PreparedStatement ps = c.prepareStatement(sql);){
			ps.setString(1,n.getTitle());
			ps.setString(2,n.getImg());
			ps.setString(3,n.getContent());
			ps.executeUpdate();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	
	public List<News> getAll() throws Exception {
		List<News> newsList = new ArrayList<>();

		String sql = "SELECT aid,title,FORMATDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate FROM news";

		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				News n = new News();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("cdate"));

				newsList.add(n);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return newsList;
	}
	
	
	public News getNews(int aid) throws Exception {
		News n = null;
		
		
		String sql = "SELECT aid, title,img, FORMATDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate, content FROM news where aid=?";
		
		try(Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				){
			ps.setInt(1, aid);
			try (ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					n = new News(); 
					n.setAid(rs.getInt("aid"));
					n.setTitle(rs.getString("title"));
					n.setImg(rs.getString("img"));
					n.setDate(rs.getString("cdate"));
					n.setContent(rs.getString("content"));
					ps.executeQuery();
				}
			}
			
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return n;
	}
	
	public void delNews(int aid) throws Exception{
		String sql = "delete FROM news WHERE aid = ?";
		
		try(Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
			ps.setInt(1, aid);
			ps.executeUpdate();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
