package pro.sky.demoexceptions.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.exceptions.EmployeeNotFoundException;
import pro.sky.demoexceptions.exceptions.OverFlowEmployeeBookException;
import pro.sky.demoexceptions.exceptions.UniqueEmployeeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @Test
    void shouldThrowOverFlowEmployeeBookException() {
        int maxSize = 5;
        int cntEmp = 0;

        for (char i = 'a'; i < 'x' && cntEmp < maxSize; i++) {
            out.addEmployee("Zivert" + i, "Zivert" + i, 1, 1);
            cntEmp++;
        }

        assertThrows(OverFlowEmployeeBookException.class, () -> out.addEmployee("Zivert", "Zivert", 1, 1));
    }

    @Test
    void shouldThrowUniqueEmployeeException() {

        out.addEmployee("Zivert", "Zivert", 1, 1);

        assertThrows(UniqueEmployeeException.class, () -> out.addEmployee("Zivert", "Zivert", 1, 1));
    }


    @Test
    void removeEmployeeTest() {

        out.addEmployee("Zivert", "Zivert", 1, 1);

        Employee expectedResult = new Employee("Zivert", "Zivert", 1, 1);

        Assertions.assertEquals(out.removeEmployee("Zivert", "Zivert"), expectedResult);
    }

    @Test
    void shouldThrowExceptionWhenRemoveEmployeeTest() {

        out.addEmployee("Zivert", "Zivert", 1, 1);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee("Eminem", "Eminem"));
    }


    @Test
    void findEmployeeTest() {
        out.addEmployee("Zivert", "Zivert", 1, 1);

        Employee expectedResult = new Employee("Zivert", "Zivert", 1, 1);

        Assertions.assertEquals(out.findEmployee("Zivert", "Zivert"), expectedResult);
    }

    @Test
    void shouldThrowExceptionWhenFindEmployeeTest() {

        out.addEmployee("Zivert", "Zivert", 1, 1);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee("Eminem", "Eminem"));
    }

    @Test
    void getEmployeeBookTest() {
        out.addEmployee("Zivert", "Zivert", 1, 1);
        out.addEmployee("Eminem", "Eminem", 1, 1);

        Employee zivert = new Employee("Zivert", "Zivert", 1, 1);
        Employee eminem = new Employee("Eminem", "Eminem", 1, 1);

        Map<Integer, Employee> ExpectedMap = new HashMap<>();

        ExpectedMap.put(0, zivert);
        ExpectedMap.put(1, eminem);

        Assertions.assertEquals(out.getEmployeeBook(), ExpectedMap);
    }
}
