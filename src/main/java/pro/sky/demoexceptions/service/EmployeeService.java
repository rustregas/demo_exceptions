package pro.sky.demoexceptions.service;

import org.springframework.stereotype.Service;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.exceptions.EmployeeNotFoundException;
import pro.sky.demoexceptions.exceptions.OverFlowEmployeeBookException;
import pro.sky.demoexceptions.exceptions.UniqueEmployeeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employeeBook;
    private final int maxSizeList = 2;

    public EmployeeService() {
        this.employeeBook = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        if (employeeBook.contains(emp)) {
            throw new UniqueEmployeeException("В массиве есть сотрудник, когда сотрудника пытаются добавить в массив");
        } else if (employeeBook.size() < maxSizeList) {
            employeeBook.add(emp);
        } else {
            throw new OverFlowEmployeeBookException("Список переполнен");
        }
        return emp;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        for (int i = 0; i < employeeBook.size(); i++) {
            if (employeeBook.contains(emp)) {
                employeeBook.remove(i);
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        if (employeeBook.contains(emp)) {
            return emp;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public List<Employee> getEmployeeBook() {
        return Collections.unmodifiableList(employeeBook);
    }
}