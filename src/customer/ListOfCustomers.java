package customer;

import interfaces.AddCustomer;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class create list of customers and implement
 * interface addCustomer
 */
public class ListOfCustomers implements AddCustomer {


    ArrayList<Customer> listOfCustomers = new ArrayList<>();

    /**
     * this method is using object pool pattern for
     * adding new object to array list
     */
    public ListOfCustomers() {
        for(int i = 0; i < 100; i++){
            listOfCustomers.add(new Customer());
        }
        this.listOfCustomers = new ArrayList<>();
    }

    /**
     * This method is for creating new Customer object
     * @return new customer object
     */
    public Customer createCustomer(){
        if(listOfCustomers.isEmpty()){
            return new Customer();
        }else {
            Customer customer=  listOfCustomers.get(0);
            listOfCustomers.remove(0);
            return customer;
        }
    }


    public ArrayList<?> getListOfCustomers(){
        return listOfCustomers;
    }

    @Override
    public void addCustomer(Customer customer) {
        listOfCustomers.add(customer);
    }

    /**
     *
     * @param o check if object O is instance of list of customer
     * @return if true than return list of customers
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfCustomers)) return false;
        ListOfCustomers that = (ListOfCustomers) o;
        return Objects.equals(listOfCustomers, that.listOfCustomers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfCustomers);
    }
}
