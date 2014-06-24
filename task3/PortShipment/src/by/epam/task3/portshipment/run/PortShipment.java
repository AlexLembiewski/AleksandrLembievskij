/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task3.portshipment.run;

import by.epam.task3.portshipment.entity.Port;
import by.epam.task3.portshipment.entity.Ship;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Администратор
 */
public class PortShipment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Port port = new Port(80, 50, 2);

        ExecutorService portEx = Executors.newFixedThreadPool(port.getNumberOfBerthes());

        Thread ship1 = new Thread(new Ship(port, "Isabella", 10, 50));
        Thread ship2 = new Thread(new Ship(port, "Victoria", 30, 50));
        Thread ship3 = new Thread(new Ship(port, "Pearl", 25, 50));

        portEx.execute(ship1);
        portEx.execute(ship2);
        portEx.execute(ship3);
        
        portEx.shutdown();
        
    }

}
