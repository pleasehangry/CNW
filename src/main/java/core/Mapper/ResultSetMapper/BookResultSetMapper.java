package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;

import Model.Bean.Book;

public class BookResultSetMapper implements IResultSetMapper<Book>{

	@Override
	public Book map(ResultSet row) {
		// TODO Auto-generated method stub
		Book book = new Book();
		try {
			if(row == null || row.getRow() == 0) {
				return null;
			}
			book.setId(row.getString("id"));
			book.setName(row.getString("name"));
			book.setAmount(row.getInt("amount"));
			book.setCategory(row.getString("category"));
			book.setImage(row.getString("image"));
			book.setDay(row.getDate("day"));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return book;
	}
	

}
