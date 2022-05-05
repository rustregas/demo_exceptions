package pro.sky.demoexceptions.service;

import org.springframework.stereotype.Service;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.exceptions.EmployeeNotFoundException;
import pro.sky.demoexceptions.exceptions.OverFlowEmployeeBookException;
import pro.sky.demoexceptions.exceptions.UniqueEmployeeException;

@Service
public class EmployeeService {
    private final Employee[] employeeBook = new Employee[2];

    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        boolean uniqueFLg = false;
        boolean addFlg = false;

        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].equals(emp)) {
                uniqueFLg = true;
                break;
            }
            if (employeeBook[i] == null) {
                employeeBook[i] = emp;
                addFlg = true;
                break;
            }
        }

        if (uniqueFLg) {
            throw new UniqueEmployeeException("В массиве есть сотрудник, когда сотрудника пытаются добавить в массив");
        } else if (!addFlg) {
            throw new OverFlowEmployeeBookException("Массив переполнен");
        } else {
            return emp;
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].equals(emp)) {
                employeeBook[i] = null;
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        for (Employee employee : employeeBook) {
            if (employee != null && employee.equals(emp)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}