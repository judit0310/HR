import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.uni.miskolc.hr.dao.EmployeeDAO;
import hu.uni.miskolc.hr.exceptions.EmployeeIDIsOccupiedException;
import hu.uni.miskolc.hr.exceptions.EmployeeNotFoundException;
import hu.uni.miskolc.hr.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class EmployeeDAOJSON implements EmployeeDAO
{
    /**
     * Mapper for JSON
     */
    ObjectMapper mapper;

    /**
     * The data file
     */
    File jsonfile;

    public EmployeeDAOJSON(String filename) {
        /**
         * The configuration of the mapper for handling the LocalDate correctly.
         */
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        /**
         * The loading of the file, and if it is not exist, creation of the file.
         */
        jsonfile = new File(filename);
        if(!jsonfile.exists()){
            try {
                jsonfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Collection<Employee> readEmployees() {
        Collection<Employee> employees = new HashSet<Employee>();
        try {
            employees = mapper.readValue(jsonfile, new TypeReference<HashSet<Employee>>(){});
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return employees;

    }

    @Override
    public Employee readEmployeeById(String employeeId) throws EmployeeNotFoundException {
        Collection<Employee> employees = new HashSet<Employee>();
        try {
            employees = mapper.readValue(jsonfile, new TypeReference<HashSet<Employee>>(){});
            for(Employee e : employees){
                if (e.getEmployeeId().equalsIgnoreCase(employeeId)) {
                    return e;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        throw new EmployeeNotFoundException(employeeId);
    }

    @Override
    public void createEmployee(Employee employee) throws EmployeeIDIsOccupiedException {
        Collection<Employee> employees = readEmployees();
        /**
         * Status variable for determining if the id is already used
         */
        boolean uniqueId = true;
        for(Employee e : employees){
            if(e.getEmployeeId().equals(employee.getEmployeeId())){
                uniqueId = false;
            }
        }
        if(!uniqueId){
           throw new EmployeeIDIsOccupiedException(employee.getEmployeeId());
        }
        employees.add(employee);
       try {
            mapper.writeValue(jsonfile, employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(Employee employee) {
        //TODO

    }

    @Override
    public void deleteEmployee(String employeeId) {
        //TODO

    }
}
