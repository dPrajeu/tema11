package siit.tema11.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.tema11.model.OrderEntity;
import siit.tema11.service.CustomerService;
import siit.tema11.service.OrderService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/store")
public class OrderController {
    private OrderService orderService;


    @RequestMapping(method = RequestMethod.GET, path = {"/show-all-orders"})
    public String showOrder(Model model) {

        List<OrderEntity> orderEntityList = orderService.getAllOrders();
        model.addAttribute("orderList", orderEntityList);

        return "orders";
    }

}
