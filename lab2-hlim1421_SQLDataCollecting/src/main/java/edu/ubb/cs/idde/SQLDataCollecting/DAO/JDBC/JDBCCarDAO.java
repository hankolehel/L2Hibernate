package edu.ubb.cs.idde.SQLDataCollecting.DAO.JDBC;

import edu.ubb.cs.idde.SQLDataCollecting.DAO.CarDAO;
import edu.ubb.cs.idde.SQLDataCollecting.DAO.GenericDAO;
import edu.ubb.cs.idde.SQLDataCollectingHibernate.Model.CarData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class JDBCCarDAO implements CarDAO, GenericDAO{
	
    public List<CarData> getAllCars() {
        Connector conn = new Connector("root","");
        conn.connect();
        Connection connection = (Connection) conn.getConnection();
        
		ArrayList<CarData> everyCar = new ArrayList<CarData>();
		ResultSet output = null;
		Statement statement;
    	try {
			statement = connection.createStatement();
			output = statement.executeQuery("SELECT CarID, Brand, Model, FabricationYear, CilinderCapacity FROM Cars");
		} catch (Exception e) {
			e.printStackTrace();
		}

        try {
			while (output.next()){
					CarData individualCar = new CarData(
							output.getInt("CarID"),
							output.getString("Brand"),
							output.getString("Model"),
							output.getInt("FabricationYear"),
							output.getInt("CilinderCapacity"));
					everyCar.add(individualCar);
									
			    //System.out.println(output.getString("Brand"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        return everyCar;
    }

    public List<CarData> getAll() {
        return getAllCars();
    }
}
