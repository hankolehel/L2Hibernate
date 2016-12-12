package edu.ubb.cs.idde.SQLHibernate.DAO;

import edu.ubb.cs.idde.SQLHibernate.model.CarsEntity;

import java.util.List;

public interface CarDAO {
    List<CarsEntity> getAllCars();
}
