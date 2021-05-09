package bill;


import customer.Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>This class is creating document for bill </p>
 */
public class DocumentBuilder {

    protected Customer customer;
    protected double price;
    protected String date;
    protected String vehicle;
    protected String signature;
    protected String lastName;
    protected String firstName;
    protected boolean reservation;


    /**
     *
     * @return object vehicle
     */
    public String getVehicle() {
        return vehicle;
    }

    /**
     *
     * @return object this, that mean return date from this method
     */
    public DocumentBuilder date() {
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter dateNowFormatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        date = dateNow.format(dateNowFormatted);
        return this;
    }

    /**
     *
     * @param firstName string variable first name of customer
     * @return first name of customer from main
     */
    public DocumentBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    /**
     *
     * @param signature string variable
     * @return signature of customer from main
     */
    public DocumentBuilder signature(String signature) {
        this.signature = signature;
        return this;
    }

    /**
     *
     * @param lastName string variable
     * @return last name of customer
     */
    public DocumentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     *
     * @param vehicle string var
     * @return name of vehicle from main
     */
    public DocumentBuilder vehicle(String vehicle) {
        this.vehicle = vehicle;
        return this;
    }


    /**
     *
     * @param price double variable price of vehicle
     * @return price of vehicle
     */
    public DocumentBuilder vehiclePrice(double price) {
        this.price = price;
        return this;
    }


    /**
     *
     * @return better form for bill document
     */
    @Override
    public String toString() {
        return "Bill Document: \n\n" +
                "LastName = " + lastName + "\n" +
                "FirstName = " + firstName + "\n" +
                "Signature = " + signature + "\n" +
                "Vehicle = " + vehicle + "\n" +
                "Date = " + date + "\n" +
                "Price = " + price;
    }
}
