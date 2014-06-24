/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task3.portshipment.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Администратор
 */
public class ShipTest {
    
    public ShipTest() {
    }

      /**
     * Test of getFreeSpace method, of class Ship.
     */
    @Test
    public void testGetFreeSpace() {
        System.out.println("getFreeSpace");
        Ship instance = new Ship();
        instance.setCapacity(82);
        instance.setCargo(40);
        int expResult = 42;
        int result = instance.getFreeSpace();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Ship.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Port port = new Port();
        Ship instance = new Ship(port, "Test", 12, 23);
        Ship newInstance = new Ship(port, "Test", 12, 23);
        boolean expResult = true;
        boolean result = instance.equals(newInstance);
        assertEquals(expResult, result);
    }
    
}
