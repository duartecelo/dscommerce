package com.duartecelo.dscommerce.services;

import com.duartecelo.dscommerce.dto.ProductDTO;
import com.duartecelo.dscommerce.entities.Product;
import com.duartecelo.dscommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(x -> modelMapper.map(x, ProductDTO.class));
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        product = productRepository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productRepository.getReferenceById(id);

        modelMapper.map(productDTO, product);
        product.setId(id);
        product = productRepository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }
}
