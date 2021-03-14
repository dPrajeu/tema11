package siit.tema11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.tema11.model.OrderEntity;
import siit.tema11.repository.CustomerRepository;
import siit.tema11.repository.OrderRepository;


import java.util.List;

@Service
@Configurable
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<OrderEntity> getAllOrders (){
        return orderRepository.findAll();
    }
}
