package siit.tema11.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import siit.tema11.model.ProductEntity;
import siit.tema11.service.ProductService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/store")
public class ProductController {
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, path = {"/show-all-products"})
    public String showProductsPage(Model model) {

        List<ProductEntity> productEntityList = productService.getAllProducts();
        model.addAttribute("productList", productEntityList);
        return "products";
    }
}
