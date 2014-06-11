
package by.epam.task01.appliance.bl;

import by.epam.task01.appliance.entity.Appliance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Класс, содержащий методы бизнес-логики для работы с 
 * объектами класса Appliance
 * @author Alex
 */

public class ApplianceWorker {

    private List<Appliance> appliances;

    public ApplianceWorker(List<Appliance> appliances) {
        this.appliances = new ArrayList<>(appliances);
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
        
    public List<Appliance> sortAppliances() {
        Collections.sort(appliances);
        return appliances;
    }
    
    public List<Appliance> selectByPowerConsumption(int minValue, int maxValue) {
        Iterator<Appliance> iterator = appliances.iterator();
        while(iterator.hasNext()) {
            Appliance appliance = iterator.next();
            if (appliance.getPowerConsumption() < minValue || appliance.getPowerConsumption() > maxValue) {
                iterator.remove();
            }
        }
        return appliances;
    }
}
