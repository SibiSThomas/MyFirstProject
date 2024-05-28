package study.service;

import org.springframework.web.multipart.MultipartFile;
import study.model.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    Employee saveEmployee(MultipartFile file, String employeeName, String employeeEmail, String employeePassword, LocalDate dob);

    Employee updateEmployee(MultipartFile file, int id, String employeeName, String employeeEmail, String employeePassword, LocalDate dob);
}
