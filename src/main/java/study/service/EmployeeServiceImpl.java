package study.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import study.model.Employee;
import study.repository.EmployeeRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(MultipartFile file, String employeeName,
                                 String employeeEmail, String employeePassword, LocalDate dob) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeePassword(employeePassword);
        employee.setDob(dob);

        try {
            String image = Base64.getEncoder().encodeToString(file.getBytes());
            employee.setEmployeeImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(MultipartFile file, int id, String employeeName, String employeeEmail, String employeePassword, LocalDate dob) {

        Employee e = employeeRepository.findById(id).get();
        e.setEmployeeName(employeeName);

        return null;
    }
}
