/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.database;

import java.sql.*;

import java.util.Scanner;

import com.algonquin.cst8288.assignment2.event.*;
import com.algonquin.cst8288.assignment2.logger.*;


/**
 * Manages database operations for events, including CRUD.
 */
public class DBOperations {
	
    private static Connection connection;
    
    /**
     * Initializes a new instance to establish a database connection.
     */
    public DBOperations() {
        this.connection = DBConnection.getInstance().getConnection();
    } 

 
    /**
     * Creates a new event in the database.
     * 
     * @param event The event to be added to the database.
     */
	public void createEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees, event_type) VALUES (?, ?, ?, ?, ?)";
      
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            statement.setString(3, event.getEventActivities());
            statement.setDouble(4, event.getAdmissionFees());
            statement.setString(5, event.getEventType());       
         
            statement.executeUpdate();
         
//            System.out.println("Create Successful!");
            LMSLogger.getInstance().log(LogLevel.INFO, "Successfully created event: " + event.getEventName());
        } catch (SQLException e) {
//            e.printStackTrace();
        	LMSLogger.getInstance().log(LogLevel.ERROR, "Failed to create event: " + e.getMessage(), e);
        }
	}

    /**
     * Retrieves an event from the database by its ID.
     * 
     * @param event_id The ID of the event to retrieve.
     * @return The retrieved event, or null if no event is found with the given ID.
     */
	public Event retrieveEvent(int event_id) {
		
	    Event event = null;
	    try {
	        String query = "SELECT * FROM events WHERE event_id = ?";
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, event_id);
	        ResultSet rs = stmt.executeQuery();
	
	        if (rs.next()) {	 	        	
	        	System.out.println("The retrieve result is: ");
	        	System.out.println("Event ID = " +rs.getInt("event_id"));
	        	System.out.println("Event Name = "+ rs.getString("event_name"));
	        	System.out.println("Event Description = " + rs.getString("event_description"));
	        	System.out.println("Event Activity = " + rs.getString("event_activities"));
	        	System.out.println("Event Admission Fee = " + rs.getDouble("admission_fees"));
	        	System.out.println("Event Type = " + rs.getString("event_type"));
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return event;
	}

	
    /**
     * Updates the name of an existing event identified by its ID.
     * 
     * @param event_id The ID of the event to update.
     */
	public void updateEvent(int event_id) {
		System.out.println("Please enter the new event name: ");
	    Scanner keyboard = new Scanner(System.in);
	    String newName = keyboard.nextLine();
	    
		String sql = "UPDATE events SET event_name = ? WHERE event_id = ?";
       
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newName);
	        stmt.setInt(2, event_id);
	      
	        stmt.executeUpdate();
//	        System.out.println("Update Successful！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

    /**
     * Deletes an event from the database by its ID.
     * 
     * @param event_id The ID of the event to delete.
     */
	public void deleteEvent(int event_id) {
        String sql = "DELETE FROM events WHERE event_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,event_id);
            statement.executeUpdate();
            System.out.println("Delete Successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
