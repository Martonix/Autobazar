package exceptions;



public class LackOfFundsException extends Exception {

   protected double funds;

    public LackOfFundsException(String message,double funds) {
        super(message);
        this.funds = funds;
    }


}
