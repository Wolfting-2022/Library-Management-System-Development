/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.event;

import java.util.Scanner;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Represents a book launch event, extending the generic Event class.
 */
public class BookLaunch extends Event {
    
    /**
     * Constructor for BookLaunch event. Initializes the event with a name, description, and activities
     * by prompting the user for input through the console.
     */
	public BookLaunch() {
    	this.eventName = inputName();
		this.eventDescription = inputDescrib();
		this.eventActivities = inputAct();
  	    setEventType(EventType.BOOK_LAUNCH);    
    }
    
    /**
     * Prompts the user to input the activities for the book launch event.
     * 
     * @return The activities as a string.
     */
    public String inputAct() {
		System.out.println("Please input the Book Launch Activity: ");
		Scanner keyboards = new Scanner(System.in);
		String act = keyboards.nextLine();
	    return act;	
	}

    /**
     * Prompts the user to input the description for the book launch event.
     * 
     * @return The description as a string.
     */
	public String inputDescrib() {
		System.out.println("Please input the Book Launch description: ");
		Scanner keyboards = new Scanner(System.in);
		String des = keyboards.nextLine();
	    return des;	
	}
	
    /**
     * Prompts the user to input the name for the book launch event.
     * 
     * @return The name as a string.
     */
	public String inputName() {		
		System.out.println("Please input the Book Launch name: ");
		Scanner keyboards = new Scanner(System.in);
		String name = keyboards.nextLine();
	    return name;	
	}


    /**
     * Calculates the admission fee for the book launch event based on predefined rates and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
    }
    
    /**
     * Generates a string representation of the book launch event, including specific details.
     * 
     * @return A string representation of the book launch event.
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Specific details for Book Launch...";
    }
}
