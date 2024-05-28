package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import study.model.Employee;
import study.repository.EmployeeRepository;
import study.service.EmployeeService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("employee/save")
    public Employee saveEmployee(@RequestPart MultipartFile file, String employeeName,
                                 String employeeEmail, String employeePassword, LocalDate dob){

        return  employeeService.saveEmployee(file,employeeName,employeeEmail,employeePassword,dob);

    }
    @GetMapping("employee/findAll")
    public List<Employee> findAllEmployees(){
        return  employeeRepository.findAll();
    }

    @PostMapping("employee/update")
    public Employee updateEmployee(@RequestPart MultipartFile file, int id, String employeeName,
                                   String employeeEmail, String employeePassword, LocalDate dob){
            return  employeeService.updateEmployee(file, id, employeeName, employeeEmail, employeePassword, dob);
    }

}
