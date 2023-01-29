package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.OrderDetailID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailID> {
}
