package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;

import Model.Bean.User;

public class UserResultSetMapper implements IResultSetMapper<User>{

	@Override
	public User map(ResultSet row) {
		try {
			if(row == null || row.getRow() == 0) {
				return null;
			}
			User user = new User();
			user.setId(row.getString("id"));
			user.setUsername(row.getString("username"));
			user.setPassword(row.getString("password"));
			user.setIsAdmin(row.getBoolean("isAdmin"));
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
