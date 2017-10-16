package hu.uni.miskolc.hr.model;


import hu.uni.miskolc.hr.exceptions.InvalidBirthDateException;
import hu.uni.miskolc.hr.exceptions.NegativeChildNumberException;
import hu.uni.miskolc.hr.exceptions.NegativePaymentException;

import java.time.LocalDate;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String bankAccount;
    private double payment;
    private int numberOfChildren;

    public Employee(String employeeId, String firstName, String lastName, LocalDate birthDate, Gender gender, String bankAccount, double payment, int numberOfChildren) throws InvalidBirthDateException, NegativePaymentException, NegativeChildNumberException {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setBirthDate(birthDate);
        this.gender = gender;
        this.bankAccount = bankAccount;
        setPayment(payment);
        setNumberOfChildren(numberOfChildren);
    }


    public void setBirthDate(LocalDate birthDate) throws InvalidBirthDateException {
        if(birthDate.isAfter(LocalDate.now())){
            throw new InvalidBirthDateException();
        }
        this.birthDate = birthDate;
    }

    public void setPayment(double payment) throws NegativePaymentException {
        if(payment < 0.0){
            throw new NegativePaymentException();
        }
        this.payment = payment;
    }

    public void setNumberOfChildren(int numberOfChildren) throws NegativeChildNumberException {
        if(numberOfChildren < 0){
            throw new NegativeChildNumberException();
        }
        this.numberOfChildren = numberOfChildren;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public double getPayment() {
        return payment;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}
