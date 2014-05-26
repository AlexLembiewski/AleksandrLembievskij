/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.appliance.entity;

/**
 *
 * @author Alex
 */
public class Toaster extends Appliance{
    private int numberOfSlots;  //количество отделений
    private int numberOfToasts; //количество тостов

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public int getNumberOfToasts() {
        return numberOfToasts;
    }

    public void setNumberOfToasts(int numberOfToasts) {
        this.numberOfToasts = numberOfToasts;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append(" numberOfSlots=")
                .append(numberOfSlots).append(", numberOfToasts=")
                .append(numberOfToasts).toString();
    }
    
    
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 11 * hash + this.numberOfSlots;
        hash = 11 * hash + this.numberOfToasts;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
         if (!super.equals(obj)) {
            return false;
        }
        final Toaster other = (Toaster) obj;
        if (this.numberOfSlots != other.numberOfSlots) {
            return false;
        }
        if (this.numberOfToasts != other.numberOfToasts) {
            return false;
        }
        return true;
    }
    
    
}
