package exceptions;


public class SellingCarFailed extends Exception {

    protected String vehicle;

    public SellingCarFailed(String message, String vehicle) {
        super(message);
        this.vehicle = vehicle;
    }
}
