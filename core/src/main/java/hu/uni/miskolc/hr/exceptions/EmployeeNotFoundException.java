package hu.uni.miskolc.hr.exceptions;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(String s){
          super("The following ID is not found: "+s);
}
}
