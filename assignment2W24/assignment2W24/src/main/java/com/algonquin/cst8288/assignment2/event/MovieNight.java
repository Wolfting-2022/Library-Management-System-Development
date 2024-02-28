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

public class MovieNight extends Event {
    public MovieNight() {
    	this.eventName = inputName();
		this.eventDescription = inputDescrib();
		this.eventActivities = inputAct();
  	    setEventType(EventType.MOVIE_NIGHT);  
    }

    /**
     * Prompts the user to input the activity for the movie night and returns it.
     * @return A string representing the activity of the movie night.
     */
    public String inputAct() {
		System.out.println("Please input the Movie Night Activity: ");
		Scanner keyboards = new Scanner(System.in);
		String act = keyboards.nextLine();
	    return act;	
	}

    /**
     * Prompts the user to input the description for the movie night and returns it.
     * @return A string representing the description of the movie night.
     */
	public String inputDescrib() {
		System.out.println("Please input the Movie Night description: ");
		Scanner keyboards = new Scanner(System.in);
		String des = keyboards.nextLine();
	    return des;	
	}
	
    /**
     * Prompts the user to input the name for the movie night and returns it.
     * @return A string representing the name of the movie night.
     */
	public String inputName() {		
		System.out.println("Please input the Movie Night name: ");
		Scanner keyboards = new Scanner(System.in);
		String name = keyboards.nextLine();
	    return name;	
	}

    /**
     * Calculates and sets the admission fee for the movie night based on predefined rates and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
    }
    
    /**
     * Returns a string representation of the Movie Night event, including specific details.
     * @return A detailed string of the movie night event.
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Specific details for Movie Night...";
    }
}
