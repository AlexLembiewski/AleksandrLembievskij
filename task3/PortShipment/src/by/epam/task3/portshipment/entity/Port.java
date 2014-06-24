package by.epam.task3.portshipment.entity;

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

    public Port(int capacity, int loading, int numberOfBerthes) {
        this.capacity = capacity;
        if (capacity < loading) {
            this.loading = capacity;
        } else {
            this.loading = loading;
        }
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
                .append("numberOfBerthes=").append(numberOfBerthes)
                .append(", capacity=").append(capacity)
                .append(", loading=").append(loading)
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
