package by.epam.task3.portshipment.entity;

import by.epam.task3.portshipment.dispatcher.Dispatcher;
import by.epam.task3.portshipment.exception.ShipException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static by.epam.task3.portshipment.entity.Literal.*;

/**
 *
 * @author Lembiewski
 */
public class Ship implements Runnable {

    private int cargo;
    private Port port;
    private String name;
    private int capacity;

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Ship.class);
    private static Lock lock = new ReentrantLock();

    public Ship() {

    }

    public Ship(Port port, String name, int cargo, int capacity) throws ShipException {
        try {
            if (port == null) {
                throw new IllegalArgumentException(PORT + port);
            } else if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException(NAME + name);
            } else if (capacity <= 0) {
                throw new IllegalArgumentException(CAPACITY + capacity);
            } else if (cargo < 0) {
                throw new IllegalArgumentException(CARGO + cargo);
            }
            this.port = port;
            this.name = name;
            this.capacity = capacity;
            this.cargo = (cargo > capacity) ? capacity : cargo;
        } catch (IllegalArgumentException e) {
            throw new ShipException(INVALID_PARAMETER + e.getMessage());
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public Port getPort() {
        return port;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    @Override
    public void run() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            load();
        } else {
            unload();
        }
    }

    private void unload() {
        boolean loading = false;
        Dispatcher.informShipMoored(name);
        try {
            lock.lock();
            log.info(Dispatcher.informShipAction(name, loading));
            if ((port.getCapacity() - port.getLoading() >= cargo)) {
                port.increaseLoading(cargo);
                cargo = 0;
            } else {
                log.info(Dispatcher.rejectShip(name));
            }
        } finally {
            log.info(Dispatcher.informShipFinished(name, loading));
            Dispatcher.informShipSailingAway(name);
            lock.unlock();
            Dispatcher.makeReport(this, port);
        }

    }

    public int getFreeSpace() {
        return capacity - cargo;
    }

    private void load() {
        
        int shipFreeSpace = getFreeSpace();
        boolean loading = true; 
        Dispatcher.informShipMoored(name);

        try {
            lock.lock();
            log.info(Dispatcher.informShipAction(name, loading));
            if (shipFreeSpace <= port.getLoading()) {
                cargo += shipFreeSpace;
                port.decreaseLoading(shipFreeSpace);

            } else {
                cargo += port.getLoading();
                port.setLoading(0);
            }
        } finally {
            log.info(Dispatcher.informShipFinished(name, loading));
            Dispatcher.informShipSailingAway(name);
            lock.unlock();
            Dispatcher.makeReport(this, port);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName()).append('{')
                .append(CARGO).append(cargo)
                .append(",").append(PORT).append(port)
                .append(",").append(NAME).append(name)
                .append(",").append(CAPACITY).append(capacity).append('}')
                .toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.cargo;
        hash = 47 * hash + Objects.hashCode(this.port);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + this.capacity;
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
        final Ship other = (Ship) obj;
        if (this.cargo != other.cargo) {
            return false;
        }
        if (!Objects.equals(this.port, other.port)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        return true;
    }

}
