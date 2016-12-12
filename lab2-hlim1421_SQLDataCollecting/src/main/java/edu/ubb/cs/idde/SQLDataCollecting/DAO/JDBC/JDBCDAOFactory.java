package edu.ubb.cs.idde.SQLDataCollecting.DAO.JDBC;

import edu.ubb.cs.idde.SQLDataCollecting.DAO.CarDAO;
import edu.ubb.cs.idde.SQLDataCollecting.DAO.DAOFactory;
import edu.ubb.cs.idde.SQLDataCollecting.DAO.GenericDAO;

public class JDBCDAOFactory extends DAOFactory {
	

	@Override
	public GenericDAO<?> getGenericDAO() {
		return new JDBCCarDAO();
	}

	@Override
	public CarDAO getCarDAO() {
		return new JDBCCarDAO();
	}
}
