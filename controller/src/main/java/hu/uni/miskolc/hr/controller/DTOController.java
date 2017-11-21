package hu.uni.miskolc.hr.controller;

import hu.uni.miskolc.hr.controller.dto.EmployeeRequest;
import hu.uni.miskolc.hr.exceptions.*;
import hu.uni.miskolc.hr.model.Employee;
import hu.uni.miskolc.hr.model.Gender;
import hu.uni.miskolc.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class DTOController {

    @Autowired
    EmployeeService employeeService;


    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addEmployee(@RequestBody EmployeeRequest request){
        try{
        Employee e = new Employee(request.getEmployeeId(), request.getLastName(), request.getFirstName(), LocalDate.MIN, Gender.valueOf(request.getGender()),"",0,0);
        employeeService.addEmployee(e);}
        catch (InvalidBirthDateException e){
           e.printStackTrace();
        } catch (NegativePaymentException e) {
            e.printStackTrace();
        } catch (NegativeChildNumberException e) {
            e.printStackTrace();
        } catch (EmployeeIDIsOccupiedException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateEmployee(@RequestBody hu.uni.miskolc.hr.controller.dto.EmployeeRequest request){
        try{
            Employee e = new Employee(request.getEmployeeId(), request.getLastName(), request.getFirstName(), LocalDate.MIN, Gender.valueOf(request.getGender()),"",0,0);
            employeeService.updateEmployee(e);} catch (InvalidBirthDateException e) {
            e.printStackTrace();
        } catch (NegativeChildNumberException e) {
            e.printStackTrace();
        } catch (NegativePaymentException e) {
            e.printStackTrace();
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }

    }

}
