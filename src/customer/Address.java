package customer;

/**
 * <p>Class for creating address of customer</p>
 */
public class Address {
    private int postalCode;
    private String street;
    private String city;

    public Address() {
        this.postalCode = postalCode;
        this.street = street;
        this.city = city;
    }


    public long getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
