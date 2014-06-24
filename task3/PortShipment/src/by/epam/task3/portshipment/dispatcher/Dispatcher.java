/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task3.portshipment.dispatcher;

import by.epam.task3.portshipment.entity.Port;
import by.epam.task3.portshipment.entity.Ship;
import org.apache.log4j.Logger;

/**
 *
 * @author Администратор
 */
public class Dispatcher {
    
    private static final Logger log = Logger.getLogger(Dispatcher.class);
    
    public static String informShipAction(String ship, boolean loadingState) {
        return new StringBuilder(ship)
            .append(loadingState ? " is loading..." : " is unloading...").toString();
        
    }
    
    public static String informShipFinished(String ship, boolean loadingState) {
        return new StringBuilder(ship)
                .append(loadingState ? " has finished loading" : " has finished unloading").toString();
    }
   
    public static String rejectShip(String ship) {
        return new StringBuilder("To ").append(ship)
                .append(": not enough space in port").toString();
    }
    
    public static void informShipMoored(String ship) {
        log.info(new StringBuilder(ship).append(" just moored").toString());
    }
    
    public static void informShipSailingAway(String ship) {
        log.info(new StringBuilder(ship).append(" is sailing away...").toString());
    
    }
    
    public static void makeReport(Ship ship, Port port) {
        log.info(new StringBuilder("Report: ").append(ship.getName()).append(" - ")
                .append(ship.getCargo()).append("/").append(ship.getCapacity()).append(" | ")
                .append("Port").append(" - ").append(port.getLoading()).append("/").append(port.getCapacity()).toString());
    }
    
    
    
}
