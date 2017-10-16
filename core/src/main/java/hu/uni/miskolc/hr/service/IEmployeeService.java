package hu.uni.miskolc.hr.service;

import hu.uni.miskolc.hr.model.Employee;

import java.util.Collection;

public interface IEmployeeService {

    public void addEmployee(Employee employee);

    public void removeEmployee(String employeeId);

    public void updateEmployee(Employee employee);

    public Collection<Employee> getAllEmployee();

    public Employee getEmployeeById(String employeeId);


}
