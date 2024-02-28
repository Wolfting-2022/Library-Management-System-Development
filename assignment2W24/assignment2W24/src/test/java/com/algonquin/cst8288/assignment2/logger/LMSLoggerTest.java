package com.algonquin.cst8288.assignment2.logger;

import static org.junit.Assert.assertSame;

import org.junit.Test;


public class LMSLoggerTest {

    @Test
    public void testLMSLoggerSingleton() {
        LMSLogger logger1 = LMSLogger.getInstance();
        LMSLogger logger2 = LMSLogger.getInstance();
        
        // Verify that only one instance of LMSLogger is created
        assertSame(logger1, logger2);
    }
}