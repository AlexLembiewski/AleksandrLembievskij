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
public class Fridge extends Appliance {

    private int refrigeratorCapacity; //объем холодильной камеры
    private int freezeCapacity;       //объем морозильной камеры
    private int freezeTemperature;    //температура замораживания 

    public int getRefrigeratorCapacity() {
        return refrigeratorCapacity;
    }

    public void setRefrigeratorCapacity(int refrigeratorCapacity) {
        this.refrigeratorCapacity = refrigeratorCapacity;
    }

    public int getFreezeCapacity() {
        return freezeCapacity;
    }

    public void setFreezeCapacity(int freezeCapacity) {
        this.freezeCapacity = freezeCapacity;
    }

    public int getFreezeTemperature() {
        return freezeTemperature;
    }

    public void setFreezeTemperature(int freezeTemperature) {
        this.freezeTemperature = freezeTemperature;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(" ")
                .append(getClass().getSimpleName())
                .append(" refrigeratorCapacity=")
                .append(refrigeratorCapacity)
                .append(", freezeCapacity=")
                .append(freezeCapacity)
                .append(", freezeTemperature=")
                .append(freezeTemperature).toString();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 47 * hash + this.refrigeratorCapacity;
        hash = 47 * hash + this.freezeCapacity;
        hash = 47 * hash + this.freezeTemperature;
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
        final Fridge other = (Fridge) obj;
        if (this.refrigeratorCapacity != other.refrigeratorCapacity) {
            return false;
        }
        if (this.freezeCapacity != other.freezeCapacity) {
            return false;
        }
        if (this.freezeTemperature != other.freezeTemperature) {
            return false;
        }
        return true;
    }

}
