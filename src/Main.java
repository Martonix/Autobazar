import bill.Bill;
import bill.DocumentBuilder;
import exceptions.LackOfFundsException;
import exceptions.ReservationNotExistException;
import exceptions.SellingCarFailed;
import vehicle.*;
import vehiclereservation.ReservationBuilder;
import vehiclereservation.VehicleReservation;
import customer.Address;
import customer.Customer;
import customer.ListOfCustomers;


import java.util.ArrayList;
import java.util.LinkedList;



public class Main {


    public static void main(String[] args) throws LackOfFundsException, ReservationNotExistException {


        /*
          In this part i create vehicles.
          I create this objects in two way,
          first way is classic object creation
          and second way is from Factory pattern
           I set everything in vehicle object also.

         */
        //second way from factory
        VehicleFactory factory = new VehicleFactory();
        Vehicle bmw = factory.getInstance("Car", "Bmw " , 643.45, "M6", "manual");

        //----------------

        //classic object creation
        Vehicle passeratti1 = new Car("Volkswagen ", "golf 4");
        passeratti1.setPrice( 646.64);

        //----------------

        Vehicle passeratti2 = new Car("Mercedes amg ", "GT 64s 4door");
        passeratti1.setPrice( 646.64);

        //----------------

        Vehicle passeratti3 = new Car("Audi ", "RS6 ");
        passeratti3.setPrice(646.64);

        //----------------

        Vehicle motorko = new Bike("Ducaty ", "PANIGALE");
        motorko.setPrice(35);


        /*
          In this part i create vehicleBazaar and sets to
          him vehicles what i am create in first part
         */
        VehicleBazaar vehicles= new VehicleBazaar();

        //creating list of vehicles
        LinkedList<?> listVehicles = vehicles.getListOfVehicle();

        //sets vehicles to list of vehicles
        vehicles.addVehicle(passeratti1);
        vehicles.addVehicle(passeratti2);
        vehicles.addVehicle(passeratti3);
        vehicles.addVehicle(motorko);
        vehicles.addVehicle(bmw);

        //print list of vehicles
        for (Object vehicle : listVehicles) {
            System.out.println("List of vehicles: " + vehicle);
        }

        System.out.println("----------------------------------------------------");

        /*
          In this part i create customers and customers address
         */


        Address customerAddress = new Address();
        customerAddress.setCity("Vranov nad Topľou");
        customerAddress.setPostalCode(93012);
        customerAddress.setStreet("Mlynská 1333");

        Customer customer = new Customer("Martin " , "Dobos");
        customer.setAvailableMoney(36);
        customer.createSignature();
        customer.setAddress(customerAddress);

        Customer customer2 = new Customer("Peter " , "Jozef");
        customer2.setAvailableMoney(36);
        customer2.createSignature();
        customer2.setAddress(customerAddress);



        /*
          In this part i set customers to Arraylist
         */
        ListOfCustomers LoC = new ListOfCustomers();
        LoC.addCustomer(customer);
        LoC.addCustomer(customer2);

        //create list of customers
        ArrayList<?> cstmrs = LoC.getListOfCustomers();

        //printing customers
        for(Object cstmr : cstmrs){
            System.out.println("List of customers >> " + cstmr.toString());
        }


        /*
           In this part I print information about a customer

         */

        System.out.println("----------------------------------------------------");

        System.out.println("Name of customer : " + customer.getFirstName() + ""
                + customer.getLastName() + "\n" + "Address of customer: \n    "
                + customer.getAddress("City: " + customerAddress.getCity()
                + "\n    " + "Postal code: " + customerAddress.getPostalCode()
                + "\n    " + "Street: " + customerAddress.getStreet())
                + "\n    " + "Signature of customer : " + customer.createSignature()
                + "\n    " + "Available money : " + customer.getAvailableMoney());


        System.out.println("----------------------------------------------------");

        /*

          In this part i want to check if reservation was created
          if reservation was confirm (because i have option to cancel reservation)
          and if customer have available money for buy a car
          In this part also reduce customer available money if they buy a car

         */
        //calling method
        VehicleReservation res = new VehicleReservation();
        double updateMoneyStatus = 0.0;
        double updateMoneyStatusTax = 0.0;
        //check if vehicle what customer want is in list of vehicles
        if(customer.wants(motorko)){
            res.createReservation(true);
        }
        //check if reservation was created
        if(res.createReservation()){
            res.confirmReservation(true);
            updateMoneyStatusTax =  customer.getAvailableMoney() - (motorko.getPrice() * 0.1);
        }

        //check if customer have money an if reservation was confirmed
        if(res.confirmReservation() && customer.getAvailableMoney() >= motorko.getPrice()){
            vehicles.removeCar(motorko);
           updateMoneyStatus =  customer.getAvailableMoney() - motorko.getPrice();
        }

        System.out.println("Money after a paying tax for reserved vehicle: " + updateMoneyStatusTax);

        System.out.println("----------------------------------------------------");


        /*
           In this part I created reservation for vehicle from builder
           pattern and print information about that
         */
        ReservationBuilder reservationBuilder = new ReservationBuilder().
                date().
                firstName(customer.getFirstName()).
                lastName(customer.getLastName()).
                vehicle(passeratti1.getVehicleFullName()).
                vehiclePrice(passeratti1.getPrice());


        System.out.println(reservationBuilder);

        System.out.println("----------------------------------------------------");


        //update money after buying a car
        System.out.println("Money after a buy vehicle: " + updateMoneyStatus);

        System.out.println("----------------------------------------------------");

        //print list of vehicles after removed car what was bought
        for (Object listVehicle : listVehicles) {
            System.out.println("List of cars after remove car: " + listVehicle);
        }

        System.out.println("----------------------------------------------------");


        Bill sell = new Bill();

        /*
           In this part I create bill from Builder pattern and also print
           everything about a bill
         */
        DocumentBuilder billBuilder = new DocumentBuilder().
                date().
                signature(customer.createSignature()).
                firstName(customer.getFirstName()).
                lastName(customer.getLastName()).
                vehicle(passeratti1.getVehicleFullName()).
                vehiclePrice(passeratti1.getPrice());


        try {
            System.out.println(sell.sellingCar(true));
        } catch (SellingCarFailed sellingCarFailed) {
            sellingCarFailed.printStackTrace();
        }


        // bill printing part
        System.out.println(billBuilder);

        System.out.println("----------------------------------------------------");


    }




}
