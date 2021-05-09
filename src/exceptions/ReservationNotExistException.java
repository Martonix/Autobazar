package exceptions;



public class ReservationNotExistException extends Exception{

    protected boolean vehicleReservation;

    public ReservationNotExistException(String message, boolean vehicleReservation) {
        super(message);
        this.vehicleReservation = vehicleReservation;
    }

}
