package siit.tema11.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.tema11.model.CustomerEntity;
import siit.tema11.repository.CustomerRepository;

import java.util.List;


@Service
@Configurable
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

}
