package vehicle;

import exceptions.VehicleNotExistException;

public class Vehicle extends VehicleBazaar {

    private String model;
    private String manufac;
    private double price;
    protected Vehicle vehicle;
    private String vehicleFullName;

    public Vehicle() {}


    public Vehicle(String manufac, String model){
        this.manufac = manufac;
        this.model = model;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String popis = manufac;
        String popis2 = model;
        if(vehicle != null){
            popis += vehicle.getManufac();
            popis2 += vehicle.getModel();
        }
        result.append(popis);
        result.append(popis2);
        vehicleFullName = result.toString();
        return vehicleFullName;
    }

    public Vehicle getVehicle() throws VehicleNotExistException {
        if(vehicle == null){
            throw new VehicleNotExistException("Vehicle don't exist", null);
        } else {
        return vehicle;
        }
    }

    public String getVehicleFullName() {
        return vehicleFullName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getManufac() {
        return manufac;
    }



}


