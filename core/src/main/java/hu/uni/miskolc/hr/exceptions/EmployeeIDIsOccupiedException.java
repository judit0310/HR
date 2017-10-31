package hu.uni.miskolc.hr.exceptions;

public class EmployeeIDIsOccupiedException extends Exception {

    public EmployeeIDIsOccupiedException(String s) {
        super("The following ID is occupied: "+s);
    }
}
