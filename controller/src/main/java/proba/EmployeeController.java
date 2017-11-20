package proba;

import hu.uni.miskolc.hr.exceptions.EmployeeNotFoundException;
import hu.uni.miskolc.hr.model.Employee;
import hu.uni.miskolc.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/hello")
    public void sayHello(){

    }

    @RequestMapping(value = "/getEmployees")
    public ModelAndView getEmployees(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("employees",employeeService.getAllEmployee());
        System.out.println(employeeService.getAllEmployee());
        return mav;
    }

    @RequestMapping(value = "/Employee/{employeeId}")
    public ModelAndView getEmployeeById(@PathVariable(value = "employeeId")
                                                    String employee)
            throws EmployeeNotFoundException{
        ModelAndView mav = new ModelAndView("employeedata");
        mav.addObject("employee",
                employeeService.getEmployeeById(employee));
        return mav;
    }


    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT , reason = "A kert azonosito nem talalhato")
    @ExceptionHandler(EmployeeNotFoundException.class)
    public void employeeNotFound(){

    }

    @RequestMapping(value = "/restEmployees")
    @ResponseBody
    public Collection<Employee> getRESTEmployee(){
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/restEmployee/{employeeId}")
    @ResponseBody
    public Employee getrestEmployeeById(@PathVariable(value = "employeeId")
                                                String employee)
            throws EmployeeNotFoundException{
        Employee result =  employeeService.getEmployeeById(employee);
        return result;
    }


}
