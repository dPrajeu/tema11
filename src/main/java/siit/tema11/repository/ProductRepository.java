package siit.tema11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siit.tema11.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {


}
