package pro.sky.demoexceptions.service;

import org.springframework.stereotype.Service;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.exceptions.EmployeeNotFoundException;
import pro.sky.demoexceptions.exceptions.OverFlowEmployeeBookException;
import pro.sky.demoexceptions.exceptions.UniqueEmployeeException;

import java.util.*;

@Service
public class EmployeeService {
    private Map<Integer, Employee> employeeBook;
    private final int maxSizeList = 2;
    private int i = 0;

    public EmployeeService() {
        this.employeeBook = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        if (employeeBook.containsValue(emp)) {
            throw new UniqueEmployeeException("В массиве есть сотрудник, когда сотрудника пытаются добавить в массив");
        } else if (employeeBook.size() < maxSizeList) {
            employeeBook.put(i++, emp);
        } else {
            throw new OverFlowEmployeeBookException("Список переполнен");
        }
        return emp;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (employeeBook.containsValue(emp)) {
            employeeBook.values().remove(emp);
            //map.values().remove(valueToRemove);
            return emp;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        if (employeeBook.containsValue(emp)) {
            return emp;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Map<Integer, Employee> getEmployeeBook() {
        return Collections.unmodifiableMap(employeeBook);
    }
}