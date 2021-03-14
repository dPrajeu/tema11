package siit.tema11.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import siit.tema11.service.CustomerService;

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
