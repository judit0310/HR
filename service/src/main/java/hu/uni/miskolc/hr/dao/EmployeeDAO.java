package hu.uni.miskolc.hr.dao;

import hu.uni.miskolc.hr.exceptions.EmployeeIDIsOccupiedException;
import hu.uni.miskolc.hr.model.Employee;

import java.util.Collection;

public interface EmployeeDAO {

    public Collection<Employee> readEmployees();

    public Employee readEmployeeById(String employeeId);

    public void createEmployee(Employee employee) throws EmployeeIDIsOccupiedException;

    public void updateEmployee(Employee employee);

    public void deleteEmployee(String employeeId);

}
