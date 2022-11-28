package Model.DAO;

import java.security.Timestamp;
import java.util.Date;

import Model.Bean.Book;
import Model.Bean.Reader;
import core.Mapper.ResultSetMapper.IResultSetMapper;
import core.Mapper.ResultSetMapper.ReaderResultSetMapper;

public class ReaderBAO extends BaseDAO<Reader> {

	public ReaderBAO() {
		super(new ReaderResultSetMapper());
		// TODO Auto-generated constructor stub
	}
	
	public Boolean addReader(String name, String book_id, String indentify, Date end_day) {
		String query = "INSERT INTO reader(name, book_id, indentify, end_day) values(?,?,?,?)";
		return this.executeQuery(query, new Object[] {name, book_id, indentify, end_day});
	}
	
	public Boolean updateReader(Reader reader) {
		String query = "UPDATE reader set name = ?, book_id = ?, indentify = ?, start_day = ?, end_day = ? where id = ?";
		return this.executeQuery(query, new Object[] {reader.getName(), reader.getBook_id(), reader.getIdentify(), reader.getStart_day(), reader.getEnd_day(), reader.getId()});				
	}
	
	public Boolean deleteReader(String id) {
		String query = "DELETE FROM reader where id = ?";
		return this.executeQuery(query, new Object[] {id});
	}
	
}
