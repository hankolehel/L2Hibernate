package edu.ubb.cs.idde.SQLHibernate.DAO.JDBC;

import edu.ubb.cs.idde.SQLHibernate.DAO.CarDAO;
import edu.ubb.cs.idde.SQLHibernate.DAO.GenericDAO;
import edu.ubb.cs.idde.SQLHibernate.model.CarsEntity;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBCCarDAO implements CarDAO, GenericDAO{
	
    public List<CarsEntity> getAllCars() {
		PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
		EntityManagerFactory entityManagerFactory = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit",new HashMap());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<CarsEntity> cars = entityManager.createQuery(
				"SELECT c FROM CarsEntity c WHERE c.brand LIKE :custName")
				.setParameter("custName", "Vw")
				.getResultList();
		System.out.println(cars);
		entityManager.close();

		return cars;
    }

    public List<CarsEntity> getAll() {
        return getAllCars();
    }
}
