package by.epam.task01.appliance.bl;

import by.epam.task01.appliance.entity.Appliance;
import by.epam.task01.appliance.entity.Fridge;
import by.epam.task01.appliance.entity.TV;
import by.epam.task01.appliance.entity.Toaster;
import by.epam.task01.appliance.entity.Type;
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
        if (type == Type.FRIDGE) {
            return new Fridge();
        } else if (type == Type.TOASTER) {
            return new Toaster();
        } else if (type == Type.TVSET) {
            return new TV();
        } else if (type == Type.WASHINGMACHINE) {
            return new WashingMachine();
        }
        throw new IllegalArgumentException("No such appliance " + type.toString());

    }
}
