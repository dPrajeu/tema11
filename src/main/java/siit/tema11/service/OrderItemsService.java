package siit.tema11.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.tema11.model.OrderItemsEntity;
import siit.tema11.repository.OrderItemsRepository;

import java.util.List;

@Service
@Configurable
public class OrderItemsService {

    private OrderItemsRepository orderItemsRepository;

    public List<OrderItemsEntity> getAllOrders (){
        return orderItemsRepository.findAll();
    }
}
