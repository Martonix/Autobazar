package bill;


import exceptions.SellingCarFailed;

import customer.Customer;

/**
 * <p>
 *    Simple description of Bill class.
 *    Class contain two constructors and
 *    one of them is for Builder pattern.
 *    Class also contains boolean method
 *    selling car.
 * </p>
 */

public class Bill extends DocumentBuilder {

    Customer customer;
    String signature;
    double price;
    String date;
    String vehicle;
    boolean reservation;
    String firstName;
    String lastName;

    public Bill() {
    }

    /**
     * @param build from document builder class
     */
    public Bill(DocumentBuilder build) {
        super();
        this.signature = build.signature;
        this.customer = build.customer;
        this.price = build.price;
        this.date = build.date;
        this.vehicle = build.vehicle;
        this.reservation = build.reservation;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
    }

    /**
     * @param choice boolean param
     * @return true if car was successfully sell.
     * @throws SellingCarFailed if car wasn't sell successfully
     */
    public boolean sellingCar(boolean choice) throws SellingCarFailed {

        if (choice) {
            System.out.println("Selling car was succes");
            return true;
        } else {
            throw new SellingCarFailed("Selling car was failure ", vehicle);
        }
    }
}
