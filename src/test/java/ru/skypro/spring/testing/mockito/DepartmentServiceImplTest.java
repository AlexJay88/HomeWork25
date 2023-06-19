package ru.skypro.spring.testing.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Robert", "Patrick", 100_000, 1));
        add(new Employee("Linda", "Hamilton", 300_000, 1));
        add(new Employee("Edvard", "Furlong", 400_000, 1));
    }};


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }

        when(employeeService.getAllEmployees()).thenReturn(employeeMap);
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);
        Assertions.assertEquals(employees.get(2), employeeWithMaxSalary);

    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }

        when(employeeService.getAllEmployees()).thenReturn(employeeMap);
        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);
        Assertions.assertEquals(employees.get(0), employeeWithMinSalary);

    }


    @Test
    void shouldReturnNullWhenNoEmployeesInDepartment() {
        final int departmentId = 2;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }

        when(employeeService.getAllEmployees()).thenReturn(employeeMap);


        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        Assertions.assertNull(employeeWithMaxSalary);

    }

}