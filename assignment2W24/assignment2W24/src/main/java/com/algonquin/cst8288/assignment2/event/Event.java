/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * Abstract class representing a generic event.
 * This class holds common attributes for different types of events and provides
 * the structure for managing these events, including setting and getting event details.
 */
public abstract class Event {
    
	
    protected String eventName;
    protected String eventDescription;
    protected String eventActivities;
    protected double admissionFees;
    protected EventType eventType;
    
    public String event_type;
    
    
    
    public Event() {

    }
    
    /**
     * Sets the event type based on the EventType enum.
     * @param type The type of the event.
     */
    public void setEventType (EventType type) {
    	switch(type) {
    	case KIDS_STORY:
    		event_type = "Kids_Story";
    		break;
    	case MOVIE_NIGHT:
    		event_type = "Movie_Night";
    		break;
    	case WORKSHOP:
    		event_type = "Work_Shop";
    		break;
    	case BOOK_LAUNCH:
    		event_type = "Book_Event";
    		break;
    		
    	}
    }
    
    /**
     * Gets the event type as a String.
     * @return A String representing the event type.
     */
    public String getEventType () {
    	return event_type;
    }
    
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	/**
	 * @return the eventActivities
	 */
	public String getEventActivities() {
		return eventActivities;
	}

	/**
	 * @param eventActivities the eventActivities to set
	 */
	public void setEventActivities(String eventActivities) {
		this.eventActivities = eventActivities;
	}

	/**
	 * @return the admissionFees
	 */
	public double getAdmissionFees() {
		return admissionFees;
	}

	/**
	 * @param admissionFees the admissionFees to set
	 */
	public void setAdmissionFees(double admissionFees) {
		this.admissionFees = admissionFees;
	}


	// Every library as it own admission fee
	public abstract void calculateAdmissionFee();
    
    /**
     * Provides a string representation of the event including name, description, activities, and admission fees.
     * @return A formatted string with event details.
     */
//    @Override
//    public String toString() {
//        return "Event Name: " + eventName + "\n" +
//               "Description: " + eventDescription + "\n" +
//               "Activities: " + eventActivities + "\n" +
//               "Admission Fees: $" + admissionFees;
//    }
    
}
