package edu.ubb.cs.idde.SQLHibernate.DAO;

import java.util.List;

public interface GenericDAO<T> {
    public List<T> getAll();
}
