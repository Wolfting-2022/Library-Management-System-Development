package com.algonquin.cst8288.assignment2.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.algonquin.cst8288.assignment2.constants.Constants;


public class WorkshopTest {

    @Test
    public void testCalculateAdmissionFee() {
        Workshop workshop = new Workshop();
        
        // Set up constants for testing
        double workshopRate = Constants.WORKSHOP_RATE;
        double workshopDuration = Constants.WORKSHOP_DURATION;
        
        // Calculate expected admission fee
        double expectedFee = workshopRate * workshopDuration;
        
        // Verify that the admission fee is calculated correctly
        workshop.calculateAdmissionFee();
        assertEquals(expectedFee, workshop.getAdmissionFees(), 0.01); // Assuming a small delta for double comparison
    }
}
