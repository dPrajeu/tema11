package siit.tema11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.tema11.model.OrderItemsEntity;


@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer> {

}
