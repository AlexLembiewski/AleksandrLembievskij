package by.epam.task3.portshipment.entity;

import by.epam.task3.portshipment.exception.PortException;
import static by.epam.task3.portshipment.entity.Literal.*;

/**
 *
 * @author Администратор
 */
public class Port {

    private int numberOfBerthes;
    private int capacity;
    private int loading;

    public Port() {
    }

    public Port(int capacity, int loading, int numberOfBerthes) throws PortException {
        try {
            if (capacity <= 0) {
                throw new IllegalArgumentException(CAPACITY + capacity);
            } else if (loading < 0 || numberOfBerthes <= 0) {
                throw new IllegalArgumentException(LOADING + loading);
            } else if (numberOfBerthes <= 0) {
                throw new IllegalArgumentException(NUMBER_OF_BERTHES + loading);
            }
        } catch (IllegalArgumentException e) {
            throw new PortException(INVALID_PARAMETER + e.getMessage());
        }
        this.capacity = capacity;
        this.loading = (loading > capacity) ? capacity : loading;
        this.numberOfBerthes = numberOfBerthes;
    }

    public int getLoading() {
        return loading;
    }

    public void setLoading(int loading) {
        this.loading = loading;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfBerthes() {
        return numberOfBerthes;
    }

    public void setNumberOfBerthes(int numberOfBerthes) {
        this.numberOfBerthes = numberOfBerthes;
    }

    public int increaseLoading(int value) {
        return loading += value;
    }

    public int decreaseLoading(int value) {
        return loading -= value;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getName()).append('{')
                .append(NUMBER_OF_BERTHES).append(numberOfBerthes)
                .append(",").append(CAPACITY).append(capacity)
                .append(",").append(LOADING).append(loading)
                .append('}').toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.numberOfBerthes;
        hash = 53 * hash + this.capacity;
        hash = 53 * hash + this.loading;
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
        final Port other = (Port) obj;
        if (this.numberOfBerthes != other.numberOfBerthes) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.loading != other.loading) {
            return false;
        }
        return true;
    }

}
