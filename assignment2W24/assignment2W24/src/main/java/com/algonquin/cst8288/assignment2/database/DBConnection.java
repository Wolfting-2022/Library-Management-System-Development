/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class for managing database connections.
 * This class utilizes the Singleton design pattern to ensure that only one instance of the database connection is created during the application's lifetime.
 * It establishes a connection to a MySQL database using JDBC.
 */
public class DBConnection {
	
	private static Connection connection = null;
    private static DBConnection instance;
	
    // Database connection details
	private String serverUrl = "jdbc:mysql://localhost:3305/bookvault";//port3306 occupied
	private String userString = "root";
	private String passwordString = "root";
	private String driverString = "com.mysql.cj.jdbc.Driver";
	
    private DBConnection() {
        try {
            Class.forName(driverString);
            this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
//            System.out.println("Database connected! ");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the single instance of DBConnection, creating it if necessary.
     * @return The single instance of DBConnection.
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    /**
     * Provides access to the database connection.
     * @return The Connection object to the database.
     */
    public Connection getConnection() {
        return connection;
    }
}
