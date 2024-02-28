/**
 * Student Name: Ting Cheng
 * Professor: Sazzad Hossain
 * Due Date: Feb. 18,2024
 * Description:  CST8288-031 Assignment2  
 * Modify Date: Feb. 15,2024 
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * This class extends {@link Library} to implement an academic library,
 * where it specializes in creating events specific to an academic context.
 */
public class AcademicLibrary extends Library {
    /**
     * Creates an event in the academic library context based on the specified event type.
     * 
     * @param type The type of event to create, as defined by {@link EventType}.
     * @return An instance of the event corresponding to the given type.
     * @throws IllegalArgumentException if the provided event type is not supported.
     */
    @Override
    public Event createEvent(EventType type) {
        switch (type) {
            case WORKSHOP:
                return new Workshop();
            case BOOK_LAUNCH:
                return new BookLaunch();
            default:
                throw new IllegalArgumentException("Event type not supported.");
        }
    }
}
