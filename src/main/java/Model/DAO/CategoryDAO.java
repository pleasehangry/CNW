package Model.DAO;

import Model.Bean.Category;
import core.Mapper.ResultSetMapper.CategoryResultSetMapper;
import core.Mapper.ResultSetMapper.IResultSetMapper;

public class CategoryDAO extends BaseDAO<Category> {

	public CategoryDAO() {
		super(new CategoryResultSetMapper());
	}
}
