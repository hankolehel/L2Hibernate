package edu.ubb.cs.idde.SQLHibernate.DAO.JDBC;

import edu.ubb.cs.idde.SQLHibernate.DAO.CarDAO;
import edu.ubb.cs.idde.SQLHibernate.DAO.GenericDAO;
import edu.ubb.cs.idde.SQLHibernate.model.CarsEntity;
import org.hibernate.jpa.HibernatePersistenceProvider;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.Logger;
-import org.slf4j.LoggerFactory;


public class JDBCCarDAO implements CarDAO, GenericDAO{
	private final static Logger LOGGER = Logger.getLogger(JDBCCarDAO.class.getName());

	private PersistenceProvider persistenceProvider;
	private EntityManagerFactory entityManagerFactory;
	private List<CarsEntity> cars;
	private EntityManager entityManager;

    public List<CarsEntity> getAllCars() {
    	LOGGER.info("Started collecting car entries");
    	try {
			persistenceProvider = new HibernatePersistenceProvider();
		}catch(Exception e){
			LOGGER.info("Failed to access PersistenceProvider");
		};
    	try{
			entityManagerFactory = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit",new HashMap());
		}catch(Exception e){
			LOGGER.info("Failed to create entityManagerFactory");
		};
		try{
			entityManagerFactory = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit",new HashMap());
		}catch(Exception e){
			LOGGER.info("Failed to create entityManagerFactory");
		};
		try{
			entityManager = entityManagerFactory.createEntityManager();
		}catch(Exception e){
			LOGGER.info("Failed to create entityManager");
		};

		//EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			cars = entityManager.createQuery(
					"SELECT c FROM CarsEntity c ")
					//.setParameter("custName", "Vw")
					.getResultList();
		}catch(Exception e){
			LOGGER.info("Failed to execute query");
		}
		System.out.println(cars);
		try{
			entityManager.close();
		}catch(Exception e){
			LOGGER.info("Failed to close entityManager");
		}
		LOGGER.info("Car entity collection successfull");
		return cars;
    }

    public List<CarsEntity> getAll() {
        return getAllCars();
    }
}
