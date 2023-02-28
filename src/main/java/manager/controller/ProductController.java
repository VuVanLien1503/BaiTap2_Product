package manager.controller;

import manager.model.Category;
import manager.model.Product;
import manager.service.ICategoryService;
import manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("product",productService.findById(id));

        return "/product/update";
    }
    @PostMapping(value = "/update/{id}")
    ModelAndView update(@ModelAttribute Product product, @PathVariable Long id ){
        product.setImg(product.getMultipartFile().getOriginalFilename());

        productService.save(product);
        ModelAndView modelAndView=new ModelAndView("/product/display");

        return modelAndView;
    }
}
