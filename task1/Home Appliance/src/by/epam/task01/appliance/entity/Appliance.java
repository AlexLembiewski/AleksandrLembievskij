package by.epam.task01.appliance.entity;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public abstract class Appliance implements Comparable<Appliance> {

    private String brandName;
    private String model;
    private int powerConsumption; //потребляемая мощность
    private int noiseLevel;       //уровень шума
    private int weight;
    private int height;
    private int width;
    private int depth;
    private boolean powerOn;

    public Appliance() {
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
                .append(" ")
                .append(" brandName=")
                .append(brandName)
                .append(", model=")
                .append(model)
                .append(", powerConsumption=")
                .append(powerConsumption)
                .append(", noiseLevel=")
                .append(noiseLevel)
                .append(", weight=")
                .append(weight)
                .append(", height=")
                .append(height)
                .append(", width=")
                .append(width)
                .append(", depth=")
                .append(depth)
                .append(", powerOn=")
                .append(powerOn).toString();
    }

    @Override
    public int compareTo(Appliance o) {
        Appliance appliance = (Appliance) o;
        return Integer.compare(this.powerConsumption, appliance.powerConsumption);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Appliance other = (Appliance) obj;

        if ((brandName == null) ? (other.brandName != null) : !brandName.equals(other.brandName)) {
            return false;
        }

        if ((model == null) ? (other.model != null) : !model.equals(other.model)) {
            return false;
        }
        if (width != other.width) {
            return false;
        }
        if (height != other.height) {
            return false;
        }
        if (depth != other.depth) {
            return false;
        }
        if (weight != other.weight) {
            return false;
        }
        if (powerOn != other.powerOn) {
            return false;
        }
        if (powerConsumption != other.powerConsumption) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.brandName);
        hash = 37 * hash + Objects.hashCode(this.model);
        hash = 37 * hash + this.powerConsumption;
        hash = 37 * hash + this.weight;
        hash = 37 * hash + this.height;
        hash = 37 * hash + this.width;
        hash = 37 * hash + this.depth;
        hash = 37 * hash + (this.powerOn ? 1 : 0);
        return hash;
    }

}
