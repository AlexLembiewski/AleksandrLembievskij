
package by.epam.task01.appliance.bl;

import by.epam.task01.appliance.entity.Appliance;
import java.util.Collections;
import java.util.List;

/**
 * Класс, содержащий методы бизнес-логики для работы с 
 * объектами класса Appliance
 * @author Alex
 */

public class ApplianceWorker {

    private List<Appliance> appliances;

    public ApplianceWorker(List<Appliance> appliances) {
        this.appliances = appliances;
    }
  
    public int getTotalPowerConsumption() {
        int totalPowerConsumption = 0;
        for (Appliance appliance : appliances) {
            if (appliance.isPowerOn()) {
                totalPowerConsumption += appliance.getPowerConsumption();
            }
        }
        return totalPowerConsumption;
    
    }
        
    public void sortAppliances() {
        System.out.println("Sorting:");
        Collections.sort(appliances);
        int counter = 0;
        for (Appliance appliance : appliances) {
            System.out.println( ++counter + ") " + appliance);
        }
    }
    
    public void selectByPowerConsumption(int minValue, int maxValue) {
        System.out.println(new StringBuilder("Appliances with the power consumption in the range [")
                .append(minValue).append("W,").append(maxValue).append("W]:").toString());
        for (Appliance appliance : appliances) {
            if (appliance.getPowerConsumption() >= minValue &appliance.getPowerConsumption() <= maxValue) {
                System.out.println(appliance);
            }
        }
    }
}
