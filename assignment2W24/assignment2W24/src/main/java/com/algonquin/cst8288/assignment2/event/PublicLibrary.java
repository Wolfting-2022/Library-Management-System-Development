/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */

/**
 * Represents a public library that can create different types of events.
 * Inherits from the Library class and provides implementation for creating
 * specific event types like KidsStoryTime and MovieNight.
 */
package com.algonquin.cst8288.assignment2.event;

public class PublicLibrary extends Library {
    /**
     * Creates and returns an event based on the specified type.
     * 
     * @param type The type of event to create, as defined in EventType.
     * @return An instance of Event corresponding to the specified type.
     * @throws IllegalArgumentException If the provided event type is not supported.
     */
	
    @Override
    public Event createEvent(EventType type) {
        switch (type) {
            case KIDS_STORY:
                return new KidsStoryTime();
            case MOVIE_NIGHT:
                return new MovieNight();
            default:
                throw new IllegalArgumentException("Event type not supported.");
        }
    }
}

