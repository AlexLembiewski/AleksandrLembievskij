/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task3.portshipment.run;

import by.epam.task3.portshipment.entity.Port;
import by.epam.task3.portshipment.entity.Ship;
import by.epam.task3.portshipment.exception.PortException;
import by.epam.task3.portshipment.exception.ShipException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Администратор
 */
public class PortShipment {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PortShipment.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {        
            int portCapacity = 100;
            int portLoading = 30;
            int numberOfBerthes = 2;

            Port port = new Port(portCapacity, portLoading, numberOfBerthes);

            ExecutorService portEx = Executors.newFixedThreadPool(port.getNumberOfBerthes());

            Thread ship1 = new Thread(new Ship(port, "Isabella", 10, 50));
            Thread ship2 = new Thread(new Ship(port, "Victoria", 30, 50));
            Thread ship3 = new Thread(new Ship(port, "Pearl", 25, 50));

            portEx.execute(ship1);
            portEx.execute(ship2);
            portEx.execute(ship3);

            portEx.shutdown();
            
        } catch (PortException | ShipException ex) {
            log.error(ex);
        }
    }

}
