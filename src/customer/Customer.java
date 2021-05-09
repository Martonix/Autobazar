package customer;

import exceptions.LackOfFundsException;
import vehicle.Vehicle;
import interfaces.WantVehicle;

/**
 * <p>This class create customer object </p>
 */
public class Customer implements WantVehicle {

    String firstName;
    String lastName;
    double availableMoney;
    Address address;


    public Customer() {

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    @Override
    public String toString() {
        return "Customer name: " + firstName + " " + lastName;
    }

    /**
     *  This method create customer signature
     *  from his first and last name
     *  I take first 3 let. form first name
     *  and last 3 let. from last name
     *  and concat this string with string builder
     * @return signature of customer
     */
    public String createSignature(){
        String signature;
        StringBuilder builder = new StringBuilder();
        String first_part;
        String second_part;
        
        if(firstName.length() > 3){
            first_part = firstName.substring(0,3);
        }else{
            first_part = firstName;
        }

        if(lastName.length() > 3){
            second_part = lastName.substring(lastName.length()-3);
        }else{
            second_part = lastName;
        }
        builder.append(first_part);
        builder.append(second_part);

        signature = builder.toString();

        return signature;
    }

    @Override
    public boolean wants(Vehicle vehicle) {
        return vehicle != null;
    }

    public String getAddress(String address) {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return amount of available money
     * @throws LackOfFundsException when customer doesn't have money for buy a vehicle
     */
    public double getAvailableMoney() throws LackOfFundsException {
        Vehicle vehicle = new Vehicle();
        if(availableMoney >= vehicle.getPrice()){
        return availableMoney;
        } else {
        throw new LackOfFundsException("Don't have a lot of money", availableMoney);
        }
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }


}
