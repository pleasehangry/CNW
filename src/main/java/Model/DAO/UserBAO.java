package Model.DAO;

import Model.Bean.User;
import core.Mapper.ResultSetMapper.IResultSetMapper;

public class UserBAO extends BaseDAO<User>{

	public UserBAO(IResultSetMapper<User> mapper) {
		super(mapper);
		// TODO Auto-generated constructor stub
	}
	
	public Boolean add(User user) {
		String query = """
				INSERT INTOR USER(id, username, password, isAdmin)
				VALUE(?,?,?,?,?,?);
				""";
		return this.executeQuery(query, new Object[] {user.getId(), user.getUsername(), user.getPassword(), user.getIsAdmin()});
	}
	
	public Boolean updateUser(User user) {
		String query = "UPDATE user SET username = ?, password = ?, isAdmin = ? WHERE id = ?";
		return this.executeQuery(query, new Object[] {user.getUsername(), user.getPassword(), user.getIsAdmin(), user.getId()});
	}
	
	public Boolean deleteUser(String id) {
		return this.executeQuery("DELETE FROM user where id = ?", new Object[] {id});
	}
	public User findByUserName(String username) {
		return this.getSingleRecord("SELECT * FROM user WHERE username = ?", new Object[] {username});	
	}
	// login
	public User findByUsernameAndPassword(String username, String password) {
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";
		return this.getSingleRecord(query, new Object[] {username, password});
	}
}
