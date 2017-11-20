package proba;

import hu.uni.miskolc.hr.exceptions.EmployeeIDIsOccupiedException;
import hu.uni.miskolc.hr.exceptions.InvalidBirthDateException;
import hu.uni.miskolc.hr.exceptions.NegativeChildNumberException;
import hu.uni.miskolc.hr.exceptions.NegativePaymentException;
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
@RequestMapping(value = "/dto")
public class DTOController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = {"","/"})
    public void getIndex(){
        System.out.println("GET index");

    }

    @RequestMapping(value = "/list")
    public void getDTOs(){
        System.out.println("GET DTOS");

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addEmployee(@RequestBody proba.dto.EmployeeRequest request){
        System.out.println(request);
        System.out.println(request.getEmployeeId());
        request.getEmployeeId();
        try{
        Employee e = new Employee(request.getEmployeeId(), request.getLastName(), request.getFirstName(), LocalDate.MIN, Gender.valueOf(request.getGender()),"",0,0);
        System.out.println(e);
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
        System.out.println(employeeService.getAllEmployee());


    }


}
