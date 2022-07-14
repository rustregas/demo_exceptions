package pro.sky.demoexceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.service.DepartmentService;
import pro.sky.demoexceptions.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public DepartmentController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public List<Employee> maxSalary(@RequestParam() int departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public List<Employee> minSalary(@RequestParam() int departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployeeByDepartment(@RequestParam(required = false) String departmentId) {
        if(departmentId==null){
            return departmentService.getAllEmployee();
        } else {
            return departmentService.getAllEmployeeByDepartment(Integer.parseInt(departmentId));
        }
    }
}
