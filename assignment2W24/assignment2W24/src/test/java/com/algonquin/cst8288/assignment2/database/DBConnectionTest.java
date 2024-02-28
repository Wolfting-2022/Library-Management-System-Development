package com.algonquin.cst8288.assignment2.database;

import static org.junit.Assert.assertSame;
import org.junit.Test;


public class DBConnectionTest {

    @Test
    public void testDBConnectionSingleton() {
        DBConnection connection1 = DBConnection.getInstance();
        DBConnection connection2 = DBConnection.getInstance();
        
        // Verify that only one instance of DBConnection is created
        assertSame(connection1, connection2);
    }
}

