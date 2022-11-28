package Model.DAO;

import Model.Bean.Book;
import core.Mapper.ResultSetMapper.BookResultSetMapper;
import core.Mapper.ResultSetMapper.IResultSetMapper;

public class BookDAO extends BaseDAO<Book> {

	public BookDAO() {
		super(new BookResultSetMapper());
	}
	
	public Boolean addBook(Book book) {
		String query = "INSERT INTO book(id, name, image, amount, category, day) values(?,?,?,?,?,?)";
		return this.executeQuery(query, new Object[] {book.getId(), book.getName(), book.getImage(), book.getAmount(), book.getCategory(), book.getDay()});
	}
	
	public Boolean updateBook(Book book) {
		String query = "UPDATE set name = ?, image = ?, amount = ?, category = ? where id = ?";
		return this.executeQuery(query, new Object[] {book.getName(), book.getAmount(), book.getCategory(), book.getId()});
	}
	
	public Boolean deleteBook(String id) {
		String query = "DELETE FROM book WHERE id = ?";
		return this.executeQuery(query, new Object[] {id});
	}
}

