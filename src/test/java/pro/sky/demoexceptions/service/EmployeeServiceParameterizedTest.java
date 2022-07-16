package pro.sky.demoexceptions.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.demoexceptions.Employee;
import pro.sky.demoexceptions.exceptions.BadInputStringException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceParameterizedTest {

    private static final String ILLEGAL_CHARACTERS_NAME = "zivert123";
    private static final String LOWER_CASE_NAME = "zivert";
    private static final String UPPER_CASE_NAME = "ZIVERT";
    private static final String SPACE_NAME = "zivert ";
    private static final String CORRECT_NAME = "Zivert";
    private static final int SALARY = 100;
    private static final int DEPARTMENT = 1;


    private final EmployeeService out = new EmployeeService();

    @Test
    public static Stream<Arguments> provideParamsForAddEmployeeTests(){
        return Stream.of(
                Arguments.of(LOWER_CASE_NAME, CORRECT_NAME, SALARY, DEPARTMENT),
                Arguments.of(UPPER_CASE_NAME, CORRECT_NAME, SALARY, DEPARTMENT),

                Arguments.of(CORRECT_NAME, CORRECT_NAME, SALARY, DEPARTMENT),

                Arguments.of(CORRECT_NAME, LOWER_CASE_NAME, SALARY, DEPARTMENT),
                Arguments.of(CORRECT_NAME, UPPER_CASE_NAME, SALARY, DEPARTMENT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddEmployeeTests")
    public void shouldAddCorrectEmployee(String inputValue1, String inputValue2, int inputValue3, int inputValue4){
        String correctName = "Zivert";

        Employee actualResult = out.addEmployee(inputValue1, inputValue2, inputValue3, inputValue4);
        Employee expectedResult = new Employee(correctName, correctName, inputValue3, inputValue4);

        Assertions.assertEquals(actualResult, expectedResult);
    }


    @Test
    public static Stream<Arguments> provideParamsForAddEmployeeInvalidNamesTests(){
        return Stream.of(
                Arguments.of(ILLEGAL_CHARACTERS_NAME, CORRECT_NAME, SALARY, DEPARTMENT),
                Arguments.of(SPACE_NAME, CORRECT_NAME, SALARY, DEPARTMENT),

                Arguments.of(CORRECT_NAME, ILLEGAL_CHARACTERS_NAME, SALARY, DEPARTMENT),
                Arguments.of(CORRECT_NAME, SPACE_NAME, SALARY, DEPARTMENT)

        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddEmployeeInvalidNamesTests")
    public void shouldThrowCorrectException(String inputValue1, String inputValue2, int inputValue3, int inputValue4){
        String correctName = "Zivert";

        Assertions.assertThrows(BadInputStringException.class, () -> out.addEmployee(inputValue1, inputValue2, inputValue3, inputValue4));
    }

}