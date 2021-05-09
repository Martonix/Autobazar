package vehiclereservation;

import exceptions.ReservationNotExistException;

public class VehicleReservation extends ReservationBuilder {

    double price;
    String date;
    String vehicle;
    String firstName;
    String lastName;

    public VehicleReservation() {
    }

    public VehicleReservation(ReservationBuilder builder) {
        this.price = builder.price;
        this.date = builder.date;
        this.vehicle = builder.vehicle;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }


    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }


    public void createReservation(boolean dchoice){
        if(dchoice){
        System.out.println("Your reservation was created.\nNow you can confirm reservation (1% tax from vehicle price),\nor cancel reservation.");

        System.out.println("----------------------------------------------------");
        }
    }

    public boolean createReservation(){
        return true;
    }


    public void confirmReservation(boolean rchoice) throws ReservationNotExistException {
        if(rchoice){
            System.out.println("You paying tax for reservation 1% from vehicle price.");
        }else {
            throw new ReservationNotExistException("Your reservation was canceled.", false);
        }
    }

    public boolean confirmReservation(){
        return true;
    }











}
