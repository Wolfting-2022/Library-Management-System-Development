/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.*;
import com.algonquin.cst8288.assignment2.logger.*;

/**
 * The Client class serves as the entry point.
 * 
 * @author Ting Cheng
 * @version 2.0
 */
public class Client {
    /**
     * Main method to demonstrate event management operations including creation, retrieval,
     * update, and deletion of events. It also showcases logging of informational messages and errors.
     * 
     * @param args Command line arguments.
     */
	public static void main(String[] args) {
		LMSLogger logger = LMSLogger.getInstance();
		logger.log(LogLevel.INFO, "Application started.");
		try {
			// Application logic that might throw an exception
		} catch (Exception e) {
			logger.log(LogLevel.ERROR, "An error occurred: ", e);
		}

		DBOperations dbOperations = new DBOperations();

		// create workshop
		Event workshop = new Workshop();
		workshop.calculateAdmissionFee();
		dbOperations.createEvent(workshop);
		logger.log(LogLevel.INFO, "Workshop event created successfully.");

		// create kidsStoryTime
		Event kid = new KidsStoryTime();
		kid.calculateAdmissionFee();
		dbOperations.createEvent(kid);
		logger.log(LogLevel.INFO, "KidsStoryTime event created successfully.");

		// create booklunch
		Event booklunch = new BookLaunch();
		booklunch.calculateAdmissionFee();
		dbOperations.createEvent(booklunch);
		logger.log(LogLevel.INFO, "BookLaunch event created successfully.");

		// create movienight
		Event movienight = new MovieNight();
		movienight.calculateAdmissionFee();
		dbOperations.createEvent(movienight);
		logger.log(LogLevel.INFO, "MovieNight event created successfully.");

		// retrive the first event in the database
		try {
			Event retrievedEvent = dbOperations.retrieveEvent(1);
			if (retrievedEvent != null) {
				logger.log(LogLevel.INFO, "Successfully retrieved event: " + retrievedEvent.getEventName());
			} else {
				logger.log(LogLevel.WARN, "No event found with ID: 1");
			}
		} catch (Exception e) {
			logger.log(LogLevel.ERROR, "Error retrieving event with ID: 1", e);
		}

		// update the second event in the database
		dbOperations.updateEvent(3);

		// delete the first event in the database
		dbOperations.deleteEvent(1);

		logger.log(LogLevel.INFO, "Event management operations completed.");
	}
}
