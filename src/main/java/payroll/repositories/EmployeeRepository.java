package payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
