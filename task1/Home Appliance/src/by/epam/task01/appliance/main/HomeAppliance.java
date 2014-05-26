package by.epam.task01.appliance.main;

import by.epam.task01.appliance.bl.SimpleApplianceFactory;
import by.epam.task01.appliance.bl.ApplianceWorker;
import by.epam.task01.appliance.entity.Appliance;
import by.epam.task01.appliance.entity.Fridge;
import by.epam.task01.appliance.entity.TV;
import by.epam.task01.appliance.entity.Toaster;
import by.epam.task01.appliance.entity.Type;
import by.epam.task01.appliance.entity.WashingMachine;
import java.util.ArrayList;
import java.util.List;

/**
 * Домашние электроприборы. Определить иерархию электроприборов. Включить
 * некоторые в розетку. Посчитать потребляемую мощность Провести сортировку
 * приборов в квартире на основе мощности. Найти прибор в квартире,
 * соответствующий заданному диапазону параметров.
 *
 * @author Alex
 */
public class HomeAppliance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Appliance> appliances = new ArrayList();

        Fridge fridge = (Fridge) SimpleApplianceFactory
                .createAppliance(Type.FRIDGE);
        fridge.setPowerConsumption(660);
        fridge.setPowerOn(true);
        
        Toaster toaster = (Toaster) SimpleApplianceFactory
                .createAppliance(Type.TOASTER);
        toaster.setPowerConsumption(350);

        TV tv = (TV) SimpleApplianceFactory
                .createAppliance(Type.TVSET);
        tv.setPowerConsumption(150);
        tv.setPowerOn(true);

        WashingMachine washmachine = (WashingMachine) SimpleApplianceFactory
                .createAppliance(Type.WASHINGMACHINE);
        washmachine.setPowerConsumption(700);
        washmachine.setPowerOn(true);

        appliances.add(fridge);
        appliances.add(toaster);
        appliances.add(tv);
        appliances.add(washmachine);

        ApplianceWorker applianceWorker = new ApplianceWorker(appliances);
        System.out.println("Total power consumption: " 
                + applianceWorker.getTotalPowerConsumption() + "W");//текущее энергопотребление
        
        applianceWorker.sortAppliances();            //сортировка электроприборов
        applianceWorker.selectByPowerConsumption(300, 660); //выборка электроприборов по потреблению

    }

}
