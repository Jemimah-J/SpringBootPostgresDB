package com.practice.service;

import com.practice.entity.Product;
import com.practice.entity.ProductDto;
import com.practice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepo.findById(id).map(this::mapToDto).orElse(null);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return mapToDto(productRepo.save(mapToEntity(productDto)));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepo.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            return mapToDto(productRepo.save(product));
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    private ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    private Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
