package siit.tema11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siit.tema11.model.OrderStatusEntity;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Integer> {



}
