package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Model.Bean.User;

public class UserDAO {
	Connection conn = null;
	Statement st = null;
	PreparedStatement preSt = null;

	public User getUser(String username, String password) throws ClassNotFoundException, SQLException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from User where username=? and password=?";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setUsername(username);
			user.setPassword(password);
			user.setIsAdmin(rs.getBoolean("isAdmin"));
			return user;
		}
		return null;
	}

	public User findUser(String username) throws ClassNotFoundException, SQLException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from User where username=?";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			String password = rs.getString("password");
			Boolean isAdmin = rs.getBoolean("isAdmin");
			User user = new User();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setIsAdmin(isAdmin);
			return user;
		}
		return null;
	}

	public ArrayList<User> getAccountList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from User where isAdmin=0";

		Statement statement = (Statement) conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		ArrayList<User> users = new ArrayList<User>();
		
		while (rs.next()) {
			String id = rs.getString("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			Boolean isAdmin = rs.getBoolean("isAdmin");
			User user = new User();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setIsAdmin(isAdmin);
			users.add(user);
		}
		return users;
	}

	public Boolean insertUser(String username, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		if(conn == null)	
			conn = ConnectDatabase.getMySQLConnection();
		String query = "INSERT INTO user(username, password) VALUES(?,?)";
		preSt = (PreparedStatement) conn.prepareStatement(query);
		preSt.setString(1, username);
		preSt.setString(2, password);
		try {
			Boolean rs = preSt.execute();
			conn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String id) throws ClassNotFoundException, SQLException {
		boolean result;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		try {
			String sql = "Delete From Book where id= ?";
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, id);
			result = pstm.execute();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public Boolean deleteAllUser() throws ClassNotFoundException, SQLException {
		Boolean result;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Delete From user";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		result = pstm.execute();
		return result;
	}

	public ArrayList<User> filterUser(String data_search) throws ClassNotFoundException, SQLException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from User where username like ?";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, "%" + data_search + "%");
		ResultSet rs = pstm.executeQuery();
		ArrayList<User> users = new ArrayList<User>();

		while (rs.next()) {
			String id = rs.getString("id");
			String password = rs.getString("password");
			Boolean isAdmin = rs.getBoolean("isAdmin");
			User user = new User();
			user.setId(id);
			user.setUsername(rs.getString("username"));
			user.setPassword(password);
			user.setIsAdmin(isAdmin);
			users.add(user);
		}
		return users;
	}

}
