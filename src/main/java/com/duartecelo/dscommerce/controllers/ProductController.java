package com.duartecelo.dscommerce.controllers;

import com.duartecelo.dscommerce.dto.ProductDTO;
import com.duartecelo.dscommerce.entities.Product;
import com.duartecelo.dscommerce.repositories.ProductRepository;
import com.duartecelo.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

}
