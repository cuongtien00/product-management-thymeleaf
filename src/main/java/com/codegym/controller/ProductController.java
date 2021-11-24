package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("products",productService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","New Product was created!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success","Product was updated!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String deleteForm(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String remove(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success","Product was removed!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }
}
