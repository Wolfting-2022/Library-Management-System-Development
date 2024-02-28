package com.algonquin.cst8288.assignment2.event;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.algonquin.cst8288.assignment2.constants.Constants;


public class KidsStoryTimeTest {

    @Test
    public void testCalculateAdmissionFee() {
        KidsStoryTime kidsStoryTime = new KidsStoryTime();
        
        // Set up constants for testing
        double kidsStoryTimeRate = Constants.KIDS_STORYTIME_RATE;
        double kidsStoryTimeDuration = Constants.KIDS_STORYTIME_DURATION;
        
        // Calculate expected admission fee
        double expectedFee = kidsStoryTimeRate * kidsStoryTimeDuration;
        
        // Verify that the admission fee is calculated correctly
        kidsStoryTime.calculateAdmissionFee();
        assertEquals(expectedFee, kidsStoryTime.getAdmissionFees(), 0.01); // Assuming a small delta for double comparison
    }
}
