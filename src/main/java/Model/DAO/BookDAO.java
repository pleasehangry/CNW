package Model.DAO;

import Model.Bean.Book;
import core.Mapper.ResultSetMapper.BookResultSetMapper;
import core.Mapper.ResultSetMapper.IResultSetMapper;

public class BookDAO extends BaseDAO<Book> {

	public BookDAO() {
		super(new BookResultSetMapper());
	}
}
