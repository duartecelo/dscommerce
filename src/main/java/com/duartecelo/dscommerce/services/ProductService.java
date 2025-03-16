package com.duartecelo.dscommerce.services;

import com.duartecelo.dscommerce.dto.ProductDTO;
import com.duartecelo.dscommerce.entities.Product;
import com.duartecelo.dscommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return modelMapper.map(product, ProductDTO.class);
    }
}
