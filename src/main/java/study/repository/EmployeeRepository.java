package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
