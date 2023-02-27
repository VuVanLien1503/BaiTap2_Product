package manager.controller;

import manager.model.Product;
import manager.service.ICategoryService;
import manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;
    @GetMapping
    String showList(Model model){
        model.addAttribute("listProduct",productService.findAll());
        return "/product/display";
    }
    @GetMapping(value = "/update/{id}")
    String showUpdate(@PathVariable("id") Long id,Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "/product/update";
    }
    @PostMapping(value = "/update")
    ModelAndView update(@ModelAttribute Product product){
        product.setImg(product.getMultipartFile().getOriginalFilename());
        productService.save(product);
        ModelAndView modelAndView=new ModelAndView("/product/display");

        return modelAndView;
    }
}
