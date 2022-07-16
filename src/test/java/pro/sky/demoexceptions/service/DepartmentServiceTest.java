package pro.sky.demoexceptions.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.demoexceptions.Employee;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static pro.sky.demoexceptions.service.Constants.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {



    @Mock
    private EmployeeService employeeServiceMock;


    @InjectMocks
    private DepartmentService out;

    @Test
    void maxSalary() {
        when(employeeServiceMock.getEmployeeBook())
                .thenReturn(DEPARTMENTALL);

        List<Employee> listMaxDep1 = List.of(DEPARTMENT1.get(0));
        List<Employee> listMaxDep2 = List.of(DEPARTMENT2.get(0), DEPARTMENT2.get(1));

//        assertThat("List equality without order",
//                actual, containsInAnyOrder(expected.toArray()));

        assertThat(out.maxSalary(1), containsInAnyOrder(listMaxDep1.toArray()));
        assertThat(out.maxSalary(2), containsInAnyOrder(listMaxDep2.toArray()));
        assertThat(out.maxSalary(3), containsInAnyOrder(List.of().toArray()));
    }

    @Test
    void minSalary() {
        when(employeeServiceMock.getEmployeeBook())
                .thenReturn(DEPARTMENTALL);

        List<Employee> listMinDep1 = List.of(DEPARTMENT1.get(1));
        List<Employee> listMinDep2 = List.of(DEPARTMENT2.get(0), DEPARTMENT2.get(1));

        assertThat(out.minSalary(1), containsInAnyOrder(listMinDep1.toArray()));
        assertThat(out.minSalary(2), containsInAnyOrder(listMinDep2.toArray()));
        assertThat(out.minSalary(3), containsInAnyOrder(List.of().toArray()));
    }

    @Test
    void getAllEmployee() {
        when(employeeServiceMock.getEmployeeBook())
                .thenReturn(DEPARTMENTALL);

        assertThat(out.getAllEmployee(), containsInAnyOrder(DEPARTMENTALLLIST.toArray()));
    }

    @Test
    void getAllEmployeeByDepartment() {
        when(employeeServiceMock.getEmployeeBook())
                .thenReturn(DEPARTMENTALL);

        assertThat(out.getAllEmployeeByDepartment(1), containsInAnyOrder(DEPARTMENT1.toArray()));
        assertThat(out.getAllEmployeeByDepartment(2), containsInAnyOrder(DEPARTMENT2.toArray()));
        assertThat(out.getAllEmployeeByDepartment(3), containsInAnyOrder(List.of().toArray()));
    }
}