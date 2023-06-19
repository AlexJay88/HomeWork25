package ru.skypro.spring.testing.mockito;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Map<Integer, List<Employee>> getDivisionByDepartmentEmployees(Integer departmentId);


}