package com.algonquin.cst8288.assignment2.event;

import static org.junit.Assert.*;
import org.junit.Test;
import com.algonquin.cst8288.assignment2.constants.Constants;


public class MovieNightTest {

    @Test
    public void testCalculateAdmissionFee() {
        MovieNight movieNight = new MovieNight();
        
        // Set up constants for testing
        double movieNightRate = Constants.MOVIE_NIGHT_RATE;
        double movieNightDuration = Constants.MOVIE_NIGHT_DURATION;
        
        // Calculate expected admission fee
        double expectedFee = movieNightRate * movieNightDuration;
        
        // Verify that the admission fee is calculated correctly
        movieNight.calculateAdmissionFee();
        assertEquals(expectedFee, movieNight.getAdmissionFees(), 0.01); // Assuming a small delta for double comparison
    }
}