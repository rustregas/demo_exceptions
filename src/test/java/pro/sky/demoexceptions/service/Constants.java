package pro.sky.demoexceptions.service;

import pro.sky.demoexceptions.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final Employee ZIVERT = new Employee("Zivert", "Zivert", 1, 1);
    public static final Employee EMINEM = new Employee("Eminem", "Eminem", 0, 1);
    public static final Employee GUF = new Employee("Guf", "Guf", 0, 2);
    public static final Employee LADYGAGA = new Employee("LADYGAGA", "LADYGAGA", 0, 2);

    public static final List<Employee> DEPARTMENT1 = List.of(
            ZIVERT,
            EMINEM
    );

    public static final List<Employee> DEPARTMENT2= List.of(
            GUF,
            LADYGAGA
    );

    public static final List<Employee> DEPARTMENTALLLIST= List.of(
            ZIVERT,
            EMINEM,
            GUF,
            LADYGAGA
    );

    public static final Map<Integer, Employee> DEPARTMENTALL= Map.of(
            0, ZIVERT,
            1, EMINEM,
            3, GUF,
            4, LADYGAGA
    );

}
