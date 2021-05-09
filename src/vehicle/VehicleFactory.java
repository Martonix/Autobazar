package vehicle;

public class VehicleFactory {
    public Vehicle getInstance(String str,String manufact, double price, String model, String gearbox) {
        if(str.equals("Car")){
            return new Car(manufact, model);
        }else if(str.equals("Bike")){
            return new Bike(manufact, model);
        }else {
            return null;
        }

    }
}
