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

    @RequestMapping("/main-page")
    public String mainPage() {
        return "FrontDesk.html";
    }





}
