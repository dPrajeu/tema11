package siit.tema11.controller;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import siit.tema11.model.CustomerEntity;
import siit.tema11.service.CustomerService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET, path = {"/showCustomer"})
    public String showCustomersPage(Model model) {

        List<CustomerEntity> customerEntityList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerEntityList);

//        CustomerCreationRequest attributeValue = new CustomerCreationRequest();
//        model.addAttribute("customerToAdd", attributeValue);
//
//        Object customerTrimisDinHtml = model.getAttribute("customerTrimisDinHtml");
//        //@ModelAttribute EmployeeEntity entity

        return "customers";


    }
}
