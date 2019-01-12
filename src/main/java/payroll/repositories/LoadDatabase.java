package payroll.repositories;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import payroll.models.Employee;
import payroll.models.Order;
import payroll.models.Status;
import payroll.repositories.EmployeeRepository;
import payroll.repositories.OrderRepository;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Employee", "1", "burglar")));
            log.info("Preloading " + employeeRepository.save(new Employee("Employee", "2", "thief")));
            log.info("Preloading " + orderRepository.save(new Order("MacBook Pro", Status.COMPLETED)));
            log.info("Preloading " + orderRepository.save(new Order("iPhone", Status.IN_PROGRESS)));
        };
    }
}
