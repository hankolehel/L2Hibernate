package edu.ubb.cs.idde.SQLDataCollecting.DAO;

import edu.ubb.cs.idde.SQLDataCollecting.DAO.JDBC.JDBCDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getInstance() {
        return new JDBCDAOFactory();
    }

    public abstract CarDAO getCarDAO();
    public abstract GenericDAO getGenericDAO();
}
