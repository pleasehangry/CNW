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
}
