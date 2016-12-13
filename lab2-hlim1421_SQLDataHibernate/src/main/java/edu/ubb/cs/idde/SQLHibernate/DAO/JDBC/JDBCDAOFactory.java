package edu.ubb.cs.idde.SQLHibernate.DAO.JDBC;

import edu.ubb.cs.idde.SQLHibernate.DAO.CarDAO;
import edu.ubb.cs.idde.SQLHibernate.DAO.DAOFactory;
import edu.ubb.cs.idde.SQLHibernate.DAO.GenericDAO;

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
