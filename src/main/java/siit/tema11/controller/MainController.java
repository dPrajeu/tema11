package siit.tema11.controller;


import lombok.AllArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.tema11.model.CustomerEntity;
import siit.tema11.model.ProductEntity;
import siit.tema11.service.CustomerService;
import siit.tema11.service.ProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/store")
public class MainController {


    private CustomerService customerService;
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET, path = {"/showCustomer"})
    public String showCustomersPage(Model model) {

        List<CustomerEntity> customerEntityList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerEntityList);

        return "customers";

    }

    @RequestMapping("/mainPage")
    public String mainPage() {
        return "FrontDesk.html";
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/showProduct"})
    public String showProductsPage(Model model) {

        List<ProductEntity> productEntityList = productService.getAllProducts();
        model.addAttribute("productList", productEntityList);
        return "products";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}/edit")
    public String showEditPage(@PathVariable(name = "customerId") String id, ModelMap modelMap) {

        CustomerEntity customer = customerService.getCustomerByID(Integer.parseInt(id));
        modelMap.addAttribute("customerToEdit", customer);

        return "editCustomer";

    }
}
