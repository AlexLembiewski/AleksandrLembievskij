package by.epam.task01.appliance.bl;

import by.epam.task01.appliance.entity.Appliance;
import by.epam.task01.appliance.entity.Fridge;
import by.epam.task01.appliance.entity.TV;
import by.epam.task01.appliance.entity.Toaster;
import by.epam.task01.appliance.entity.ApplienceType;
import by.epam.task01.appliance.entity.WashingMachine;

/**
 *
 * @author Alex
 */
public  class SimpleApplianceFactory {
 /**
  * Фабрика электроприборов
  * @param type Тип электроприбора
  * @return Новый электроприбор 
  */ 
    public static Appliance createAppliance(Enum type) {
        if (type == ApplienceType.FRIDGE) {
            return new Fridge();
        } else if (type == ApplienceType.TOASTER) {
            return new Toaster();
        } else if (type == ApplienceType.TVSET) {
            return new TV();
        } else if (type == ApplienceType.WASHINGMACHINE) {
            return new WashingMachine();
        }
        throw new IllegalArgumentException("No such appliance " + type.toString());

    }
}
