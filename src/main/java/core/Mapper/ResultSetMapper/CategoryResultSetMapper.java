package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;

import Model.Bean.Category;

public class CategoryResultSetMapper implements IResultSetMapper<Category>  {

	@Override
	public Category map(ResultSet row) {
		Category category = new Category();
		try {
			if(row == null || row.getRow() == 0) {
				return null;
			}
			category.setId(row.getInt("id"));
			category.setName(row.getString("name"));
		} catch (Exception e) {
			return null;
		}
		return category;
	}
	
}
