/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task3.portshipment.entity;

import by.epam.task3.portshipment.exception.PortException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Администратор
 */
public class PortTest {
    
    public PortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
      
    @Test
    public void testIncreaseLoading() {
        System.out.println("increaseLoading");
        int value = 22;
        Port instance = new Port();
        instance.setLoading(20);
        assertEquals(42, instance.increaseLoading(value));
    }

    /**
     * Test of decreaseLoading method, of class Port.
     */
    @Test
    public void testDecreaseLoading() {
        System.out.println("decreaseLoading");
        int value = 20;
        Port instance = new Port();
        instance.setLoading(22);
        assertEquals(2, instance.decreaseLoading(value));
       
    }

    /**
     * Test of equals method, of class Port.
     */
    @Test
    public void testEquals() {
        try {
            System.out.println("equals");
            Port anotherPort = new Port(80, 50, 2);
            Port instance = new Port(80, 50, 2);
            boolean expResult = true;
            boolean result = instance.equals(anotherPort);
            assertEquals(expResult, result);
        } catch (PortException ex) {
            Logger.getLogger(PortTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
