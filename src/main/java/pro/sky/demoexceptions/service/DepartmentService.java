package pro.sky.demoexceptions.service;

import org.springframework.stereotype.Service;
import pro.sky.demoexceptions.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> maxSalary(int departmentId) {
        List<Integer> salary = employeeService.getEmployeeBook().values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .map(s -> s.getSalary())
                .collect(Collectors.toList());

        return employeeService.getEmployeeBook().values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .filter(p -> p.getSalary() == Collections.max(salary))
                .collect(Collectors.toList());
    }

    public List<Employee> minSalary(int departmentId) {
        List<Integer> salary = employeeService.getEmployeeBook().values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .map(s -> s.getSalary())
                .collect(Collectors.toList());

        return employeeService.getEmployeeBook().values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .filter(p -> p.getSalary() == Collections.min(salary))
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployee(){
        return employeeService.getEmployeeBook().values().stream()
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeeByDepartment(int departmentId){
        return employeeService.getEmployeeBook().values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }



}
