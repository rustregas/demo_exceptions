package pro.sky.demoexceptions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.addEmployee(firstName, lastName);
    }

    @RequestMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.findEmployee(firstName, lastName);
    }

    @RequestMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.removeEmployee(firstName, lastName);
    }

}