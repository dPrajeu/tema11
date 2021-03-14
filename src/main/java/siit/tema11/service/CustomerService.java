package siit.tema11.service;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Service;
import siit.tema11.dto.CustomerAddRequest;
import siit.tema11.dto.CustomerUpdateRequest;
import siit.tema11.exception.CannotDeleteDBConstraint;
import siit.tema11.exception.CustomerNotFoundException;
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

    public CustomerEntity getCustomerByID(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer ID not found!"));
    }

    public CustomerEntity updateCustomerByID(CustomerUpdateRequest customerUpdateRequest) {
        CustomerEntity customerEntity = customerRepository.findById(customerUpdateRequest.getCustomerId()).orElseThrow(()->new CustomerNotFoundException("Customer ID not found!"));

        return customerRepository.save(customerEntity);
    }

    public void deleteCustomerByID(Integer id){
        customerRepository.deleteById(id);
    }


    public CustomerEntity createCustomer (CustomerEntity customerEntity) {
//        CustomerEntity customerEntity = customerRepository.findById(customerAddRequest.getCustomerId()).orElseThrow(()->new CustomerNotFoundException("Customer ID not found!"));

        customerEntity.setCustomerId(null);
        return customerRepository.save(customerEntity);
    }
}
