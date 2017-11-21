package hu.uni.miskolc.hr.service.impl;

import hu.uni.miskolc.hr.dao.EmployeeDAO;
import hu.uni.miskolc.hr.exceptions.EmployeeIDIsOccupiedException;
import hu.uni.miskolc.hr.exceptions.EmployeeNotFoundException;
import hu.uni.miskolc.hr.model.Employee;

import java.util.Collection;

public class EmployeeServiceImpl implements hu.uni.miskolc.hr.service.EmployeeService {

    public EmployeeDAO dao;

    public EmployeeServiceImpl(EmployeeDAO dao) {
        this.dao = dao;
    }

    public void addEmployee(Employee employee) throws EmployeeIDIsOccupiedException {
        dao.createEmployee(employee);

    }

    public void removeEmployee(String employeeId) throws EmployeeNotFoundException {
        dao.deleteEmployee(employeeId);

    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        dao.updateEmployee(employee);

    }

    public Collection<Employee> getAllEmployee() {
        return dao.readEmployees();
    }

    public Employee getEmployeeById(String employeeId) throws EmployeeNotFoundException {
        return dao.readEmployeeById(employeeId);
    }
}
