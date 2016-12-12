package edu.ubb.cs.idde.SQLDataCollecting.DAO;
import edu.ubb.cs.idde.SQLDataCollectingHibernate.Model.CarData;

import java.util.List;

public interface CarDAO {
    List<CarData> getAllCars();
}
