package hu.uni.miskolc.hr.dao;

import hu.uni.miskolc.hr.exceptions.EmployeeIDIsOccupiedException;
import hu.uni.miskolc.hr.exceptions.EmployeeNotFoundException;
import hu.uni.miskolc.hr.model.Employee;

import java.util.Collection;

public interface EmployeeDAO {

    public Collection<Employee> readEmployees();

    public Employee readEmployeeById(String employeeId) throws EmployeeNotFoundException;

    public void createEmployee(Employee employee) throws EmployeeIDIsOccupiedException;

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException;

    public void deleteEmployee(String employeeId) throws EmployeeNotFoundException;

}
