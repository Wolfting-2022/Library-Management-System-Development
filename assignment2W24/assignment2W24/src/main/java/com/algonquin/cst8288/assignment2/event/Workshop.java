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

public class Workshop extends Event {
	
    public Workshop() {
        this.eventName = inputName();
        this.eventDescription = inputDescrib();
        this.eventActivities = inputAct();
        setEventType(EventType.WORKSHOP); 
    }
    
    public String inputAct() {
		System.out.println("Please input the Work Shop Activity: ");
		Scanner keyboards = new Scanner(System.in);
		String act = keyboards.nextLine();
	    return act;	
	}

	public String inputDescrib() {
		System.out.println("Please input the Work Shop description: ");
		Scanner keyboards = new Scanner(System.in);
		String des = keyboards.nextLine();
	    return des;	
	}
	
	public String inputName() {		
		System.out.println("Please input the Work Shop name: ");
		Scanner keyboards = new Scanner(System.in);
		String name = keyboards.nextLine();
	    return name;	
	}

    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
    }
 
    /**
     * Returns a string representation of the Movie Night event, including specific details.
     * @return A detailed string of the movie night event.
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Specific details for Work Shop...";
    }
}

