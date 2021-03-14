package siit.tema11.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import siit.tema11.dto.CustomerAddRequest;
import siit.tema11.dto.CustomerUpdateRequest;
import siit.tema11.model.CustomerEntity;
import siit.tema11.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/store")
public class CustomerController {

    private CustomerService customerService;

    //=================================================================================================
    //===============================            GET               ====================================
    //=================================================================================================
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


    //=================================================================================================
    //===============================              POST            ====================================
    //=================================================================================================

    @RequestMapping(method = RequestMethod.POST, path = "/{customerID}/edit")
    public String updateCustomer(@PathVariable String customerID, @ModelAttribute(name = "customerToEdit") @Valid CustomerUpdateRequest customerUpdateRequest, Model model) {
        customerUpdateRequest.setCustomerId(Integer.parseInt(customerID));
        customerService.updateCustomerByID(customerUpdateRequest);
        return showCustomersPage(model);
    }

    //=================================================================================================
    //===============================            DELETE            ====================================
    //=================================================================================================

    @PostMapping("/{customerID}/delete")
    public String deleteCustomer(@PathVariable @Valid int customerID, Model model) {

        customerService.deleteCustomerByID(customerID);
        return showCustomersPage(model);
    }


    //=================================================================================================
    //===============================       ADD Customer           ====================================
    //=================================================================================================

    @RequestMapping(method = RequestMethod.GET, path = "/add-customer")
    public String showAddCustomerPage(ModelMap modelMap) {

        CustomerEntity attributeValue = new CustomerEntity();
        modelMap.addAttribute("customerToBeAdded", attributeValue);
        return "addCustomer";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@ModelAttribute(name = "customerToAdd") CustomerEntity customerEntity,
                              Model model) {
        customerService.createCustomer(customerEntity);
        return showCustomersPage(model);
    }

}
