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

import java.time.LocalDate;
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
        CustomerEntity customerEntity = customerRepository.findById(customerUpdateRequest.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer ID not found!"));

        customerEntity.setFirstName(customerUpdateRequest.getFirstName());
        customerEntity.setLastName(customerUpdateRequest.getLastName());
        customerEntity.setBirthDate(customerUpdateRequest.getBirthDate());
        customerEntity.setAddress(customerUpdateRequest.getAddress());
        customerEntity.setCity(customerUpdateRequest.getCity());
        customerEntity.setState(customerUpdateRequest.getState());
        customerEntity.setPhone(customerUpdateRequest.getPhone());
        customerEntity.setPoints(customerUpdateRequest.getPoints());

        return customerRepository.save(customerEntity);
    }


    public void deleteCustomerByID(Integer id) {
        customerRepository.deleteById(id);
    }


    public CustomerEntity createCustomer(CustomerAddRequest request) {

        var customerEntityBuilder = CustomerEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .address(request.getAddress())
                .city(request.getCity())
                .phone(request.getPhone())
                .points(request.getPoints())
                .state(request.getState())
                .build();
        return customerRepository.save(customerEntityBuilder);
    }
}
