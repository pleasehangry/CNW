package Model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.Book;
import Model.Bean.User;
import Model.DAO.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();
	public User getAccount(String username, String password) throws ClassNotFoundException, SQLException {
		return userDAO.getUser(username, password);
	}
	public ArrayList<User> getAccountList() throws ClassNotFoundException, SQLException {
		return userDAO.getAccountList();
	}
	public Boolean insertUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			return userDAO.insertUser(username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteAllUser() throws ClassNotFoundException, SQLException {
		return userDAO.deleteAllUser();
	}
	public boolean deleteUser(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(id);
	}
	public ArrayList<User> searchUser(String data_search) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userDAO.filterUser(data_search);
	}
}
