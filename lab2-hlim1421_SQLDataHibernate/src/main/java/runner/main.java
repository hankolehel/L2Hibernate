package runner;
import edu.ubb.cs.idde.SQLHibernate.model.CarsEntity;
import org.hibernate.jpa.HibernatePersistenceProvider;
/**
 * Created by Hanko on 12/12/2016.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;
import java.util.List;

public class main {
    public static final String SELECT_QUERY = "select brand from CarsEntity where brand = 'Vw'";

    public static void main(String[] args){
        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit",new HashMap());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<CarsEntity> cars = entityManager.createQuery(
                "SELECT c FROM CarsEntity c ")
                //.setParameter("custName", "Vw")
                .getResultList();
        System.out.println(cars);
        entityManager.close();
    }

}
