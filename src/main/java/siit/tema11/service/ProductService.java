package siit.tema11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.tema11.model.ProductEntity;
import siit.tema11.repository.ProductRepository;

import java.util.List;

@Service
@Configurable
public class ProductService {

    @Autowired
   private ProductRepository productRepository;

   public List<ProductEntity> getAllProducts() {
       return productRepository.findAll();
   }
}
