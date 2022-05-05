package pro.sky.demoexceptions.service;

import org.springframework.stereotype.Service;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.exceptions.EmployeeNotFoundException;
import pro.sky.demoexceptions.exceptions.OverFlowEmployeeBook;
import pro.sky.demoexceptions.exceptions.UniqueEmployeeException;

@Service
public class EmployeeService {
    Employee[] employeeBook = new Employee[2];

    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new UniqueEmployeeException("В массиве есть сотрудник, когда сотрудника пытаются добавить в массив");
            }
        }
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = emp;
                return employeeBook[i];
            }
        }
        throw new OverFlowEmployeeBook("Массив переполнен");
    }

    public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getFirstName().equals(firstName) && employeeBook[i].getLastName().equals(lastName)) {
                Employee emp = employeeBook[i];
                employeeBook[i] = null;
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}