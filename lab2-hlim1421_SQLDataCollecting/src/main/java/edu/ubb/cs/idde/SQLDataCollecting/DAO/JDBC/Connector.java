package edu.ubb.cs.idde.SQLDataCollecting.DAO.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class Connector{
	private String username, password;
	private Connection connection = null; 
	private Statement statement = null;
	
	
	public Connector(String paramuser, String parampassword){
		username = paramuser;
		password = parampassword;
		connection = connect();
	}
	
	
	public Connection connect(){
		Connection connectionTemp = null;
	    try {
			connectionTemp = DriverManager
			  .getConnection("jdbc:mysql://localhost:3306/kornyezetek",username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	    if (connectionTemp != null) {
	        connection = connectionTemp;
	        return connection;
	    } else {
	        System.out.println("Failed to make connection!");
	        return null;
	    }
	}
	
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }
    
	public Connection getConnection() {
		return connection;
	}
}
