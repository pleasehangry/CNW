package Model.DAO;

import Model.Bean.Category;
import core.Mapper.ResultSetMapper.CategoryResultSetMapper;
import core.Mapper.ResultSetMapper.IResultSetMapper;

public class CategoryDAO extends BaseDAO<Category> {

	public CategoryDAO() {
		super(new CategoryResultSetMapper());
	}
	
	public Boolean addCategory(String name) {
		String query = "INSERT INTO category(name) values(?)";
		return this.executeQuery(query, new Object[] {name});
	}
	
	public Boolean deleteCategory(String id) {
		return this.executeQuery("DELETE FROM category where id = ?", new Object[] {id});
	}
}
