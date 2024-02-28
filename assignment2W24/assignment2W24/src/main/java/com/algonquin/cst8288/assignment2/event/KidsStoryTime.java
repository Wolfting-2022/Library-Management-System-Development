/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.event;

import java.io.InputStream;

import java.util.*;

import com.algonquin.cst8288.assignment2.constants.Constants;

public class KidsStoryTime extends Event {
   
	public KidsStoryTime() {
		  this.eventName = inputName();
		  this.eventDescription = inputDescrib();
		  this.eventActivities = inputAct();
    	  setEventType(EventType.KIDS_STORY);      
    }
	
    /**
     * Prompts the user to input the activity for Kids Story Time and returns it.
     * @return The activity string input by the user.
     */
	public String inputAct() {
		System.out.println("Please input the kids Story Time Activity: ");
		Scanner keyboards = new Scanner(System.in);
		String act = keyboards.nextLine();
	    return act;	
	}

    /**
     * Prompts the user to input the description for Kids Story Time and returns it.
     * @return The description string input by the user.
     */
	public String inputDescrib() {
		System.out.println("Please input the kids Story Time description: ");
		Scanner keyboards = new Scanner(System.in);
		String des = keyboards.nextLine();
	    return des;	
	}
	
    /**
     * Prompts the user to input the name for Kids Story Time and returns it.
     * @return The name string input by the user.
     */
	public String inputName() {		
		System.out.println("Please input the kids Story Time name: ");
		Scanner keyboards = new Scanner(System.in);
		String name = keyboards.nextLine();
	    return name;	
	}

    /**
     * Calculates the admission fee for the Kids Story Time event based on predefined rates and duration.
     */
	@Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
    }
    
    /**
     * Returns a string representation of the Kids Story Time event, including specific details.
     * @return Detailed string of the Kids Story Time event.
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Specific details for Kids Story Time...";
    }
}