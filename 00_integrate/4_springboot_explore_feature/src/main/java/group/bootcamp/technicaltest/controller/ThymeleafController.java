package group.bootcamp.technicaltest.controller;

import group.bootcamp.technicaltest.entity.ProductEntity;
import group.bootcamp.technicaltest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping
public class ThymeleafController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping({"products", "/products"})
    public String showProductList(Model model){
        List<ProductEntity> products = productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("products", products);
        return "/products/index";
    }

    @GetMapping("/products/create")
    public String showCreatePage(Model model){

        return "/products/create";
    }

    @GetMapping("currency")
    public String exchange(@RequestParam(value ="amount") String ammount, Locale locale){
        return "/currencies/index";
    }

}
