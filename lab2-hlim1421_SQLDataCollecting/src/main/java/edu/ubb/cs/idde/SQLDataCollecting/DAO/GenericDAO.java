package edu.ubb.cs.idde.SQLDataCollecting.DAO;

import java.util.List;

public interface GenericDAO<T> {
    public List<T> getAll();
}
