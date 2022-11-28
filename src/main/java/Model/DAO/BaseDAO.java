package Model.DAO;

import java.beans.Statement;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

import core.Mapper.ResultSetMapper.IResultSetMapper;

public abstract class BaseDAO<T> {
	private IResultSetMapper<T> _mapper;
	public BaseDAO(IResultSetMapper<T> mapper) {
		_mapper = mapper;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DatabaseConfig.getConnectionString(), DatabaseConfig.name, DatabaseConfig.password);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<T> getArrayRecord(String sql){
		Connection connection = getConnection();
		ArrayList<T> data = new ArrayList<T>();
		if(connection != null) {
			try {
				java.sql.Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()) {
					T entity = _mapper.map(result);
					data.add(entity);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
			return data;
		}
		else {
			return null;
		}
	}
	
	public T getSingleRecord(String sql) {
		Connection connection = getConnection();
		if(connection != null) {
			try {
				java.sql.Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				result.next();
				T entity = _mapper.map(result);
				connection.close();
				return entity;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	// insert, update, delete
	public boolean executeQuery(String sql) {
		Connection connection = getConnection();
		if(connection != null) {
			try {
				java.sql.Statement statement = connection.createStatement();
				Boolean result = statement.execute(sql);
				connection.close();
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public T getSingleRecord(String sql, Object ...params) {
		Connection connection = getConnection();
		if(connection != null) {
			try {
				PreparedStatement statement = getPrepareStatement(connection, sql, params);
				ResultSet result = statement.executeQuery();
				result.next();
				T entity = _mapper.map(result);
				connection.close();
				return entity;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public boolean executeQuery(String sql, Object ...params) {
		Connection connection = getConnection();
		if(connection != null) {
			try {
				PreparedStatement statement = getPrepareStatement(connection, sql, params);
				int result = statement.executeUpdate();
				connection.close();
				return result >0;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private PreparedStatement getPrepareStatement(Connection connection, String sql, Object ...params) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0;i < params.length;i++) {
			if (params[i] instanceof Integer) {
				statement.setInt(i + 1, (int)params[i]);
			}else if (params[i] instanceof Float) {
				statement.setFloat(i + 1, (float)params[i]);
			}else if (params[i] instanceof String) {
				statement.setString(i + 1, (String)params[i]);
			}else if (params[i] instanceof Boolean) {
				statement.setBoolean(i + 1, (boolean)params[i]);
			}else if (params[i] instanceof Date) {
				statement.setDate(i + 1, (Date)params[i]);
			}else if (params[i] instanceof Timestamp) {
				statement.setTimestamp(i + 1, (Timestamp)params[i]);
			}else {
				statement.setObject(i + 1, params[i]);
			}
		}
		return statement;
	}
}
