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
public class TV extends Appliance {

    private int screenSize;      //размер диагонали
    private int clearMotionRate; //частота обновления экрана

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getClearMotionRate() {
        return clearMotionRate;
    }

    public void setClearMotionRate(int clearMotionRate) {
        this.clearMotionRate = clearMotionRate;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                .append(" screenSize=").append(screenSize)
                .append(", clearMotionRate=")
                .append(clearMotionRate).toString();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 83 * hash + this.screenSize;
        hash = 83 * hash + this.clearMotionRate;
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
        final TV other = (TV) obj;
        if (this.screenSize != other.screenSize) {
            return false;
        }
        if (this.clearMotionRate != other.clearMotionRate) {
            return false;
        }
        return true;
    }

}
