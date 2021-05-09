package exceptions;

import vehicle.Vehicle;

public class VehicleNotExistException extends Exception {

    protected Vehicle car;

    public VehicleNotExistException(String message, Vehicle car) {
        super(message);
        this.car = car;
    }

}
