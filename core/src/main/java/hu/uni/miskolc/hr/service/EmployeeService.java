package hu.uni.miskolc.hr.service;

import hu.uni.miskolc.hr.exceptions.EmployeeIDIsOccupiedException;
import hu.uni.miskolc.hr.exceptions.EmployeeNotFoundException;
import hu.uni.miskolc.hr.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    public void addEmployee(Employee employee) throws EmployeeIDIsOccupiedException;

    public void removeEmployee(String employeeId);

    public void updateEmployee(Employee employee);

    public Collection<Employee> getAllEmployee();

    public Employee getEmployeeById(String employeeId) throws EmployeeNotFoundException;


}
