package Model.DAO;

import Model.Bean.Reader;
import core.Mapper.ResultSetMapper.IResultSetMapper;
import core.Mapper.ResultSetMapper.ReaderResultSetMapper;

public class ReaderBAO extends BaseDAO<Reader> {

	public ReaderBAO() {
		super(new ReaderResultSetMapper());
		// TODO Auto-generated constructor stub
	}
}
