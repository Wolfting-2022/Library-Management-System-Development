package com.algonquin.cst8288.assignment2.event;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.algonquin.cst8288.assignment2.constants.Constants;


public class BookLaunchTest {

    @Test
    public void testCalculateAdmissionFee() {
        BookLaunch bookLaunch = new BookLaunch();
        
        // Set up constants for testing
        double bookLaunchRate = Constants.BOOK_LAUNCH_RATE;
        double bookLaunchDuration = Constants.BOOK_LAUNCH_DURATION;
        
        // Calculate expected admission fee
        double expectedFee = bookLaunchRate * bookLaunchDuration;
        
        // Verify that the admission fee is calculated correctly
        bookLaunch.calculateAdmissionFee();
        assertEquals(expectedFee, bookLaunch.getAdmissionFees(), 0.01); // Assuming a small delta for double comparison
    }
}
