package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;

import Model.Bean.Reader;

public class ReaderResultSetMapper implements IResultSetMapper<Reader>{

	@Override
	public Reader map(ResultSet row) {
		// TODO Auto-generated method stub
		try {
			if(row == null || row.getRow() == 0) {
				return null;
			}
			Reader reader = new Reader();
			reader.setId(row.getString("id"));
			reader.setUser_id(row.getString("user_id"));
			reader.setUserName(row.getString("userName"));
			reader.setBook(row.getString("book"));
			reader.setBook_id(row.getString("book_id"));
			reader.setIdentify(row.getString("indentify"));
			reader.setStatus(row.getString("status"));
			reader.setStart_day(row.getDate("start_day"));
			reader.setEnd_day(row.getDate("end_date"));
			return reader;
		} catch (Exception e) {
			return null;
		}
	}
	
}
