package vehicle;

import bill.Bill;
import exceptions.SellingCarFailed;
import interfaces.AddVehicle;

import java.util.LinkedList;
import java.util.Objects;

public class VehicleBazaar extends RemoveVehicle implements AddVehicle {

    LinkedList<Vehicle> listOfVehicles;

    public VehicleBazaar() {

        this.listOfVehicles = new LinkedList<>();
    }

    public LinkedList<Vehicle> getListOfVehicle() {
        return listOfVehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        listOfVehicles.add(vehicle);
        }


    @Override
    public void removeCar(Vehicle vehicle){
    Bill bill = new Bill();
        try {
            if(bill.sellingCar(true)){
                listOfVehicles.remove(vehicle);
                }
        } catch (SellingCarFailed sellingCarFailed) {
            sellingCarFailed.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleBazaar)) return false;
        VehicleBazaar that = (VehicleBazaar) o;
        return listOfVehicles.equals(that.listOfVehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfVehicles);
    }
}
