package siit.tema11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siit.tema11.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {



}
