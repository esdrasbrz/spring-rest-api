package payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
