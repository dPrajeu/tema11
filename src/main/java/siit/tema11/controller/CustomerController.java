package siit.tema11.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import siit.tema11.model.CustomerEntity;
import siit.tema11.service.CustomerService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/store")
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, path = {"/show-all-customers"})
    public String showCustomersPage(Model model) {

        List<CustomerEntity> customerEntityList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerEntityList);

        return "customers";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}/edit")
    public String showEditPage(@PathVariable(name = "customerId") String id, ModelMap modelMap) {

        CustomerEntity customer = customerService.getCustomerByID(Integer.parseInt(id));
        modelMap.addAttribute("customerToEdit", customer);

        return "editCustomer";
    }



    @RequestMapping(method=RequestMethod.POST, path="/{customerId}/edit")
    public String editCustomer(@PathVariable int customerId,
                               @ModelAttribute(name = "customerToEdit") CustomerEntity entity,
                               Model model) {

        entity.setCustomerId(customerId);
        customerService.updateCustomerByID(entity);


        return showCustomersPage(model);
    }
}
