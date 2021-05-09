package vehiclereservation;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationBuilder {
    protected String lastName;
    protected String firstName;
    protected String vehicle;
    protected String date;
    protected double price;


    public ReservationBuilder date() {
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter dateNowFormatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        date = dateNow.format(dateNowFormatted);
        return this;
    }

    public ReservationBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }



    public ReservationBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ReservationBuilder vehicle(String vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public ReservationBuilder vehiclePrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Reservation Document: \n\n" +
                "LastName = " + lastName + "\n" +
                "FirstName = " + firstName + "\n" +
                "Vehicle = " + vehicle + "\n" +
                "Date = " + date + "\n" +
                "Price = " + price;
    }
}
