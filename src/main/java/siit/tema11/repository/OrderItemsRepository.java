package siit.tema11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siit.tema11.model.OrderItemsEntity;

public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer> {



}
