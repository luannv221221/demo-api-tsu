package com.ra.service.impl;

import com.ra.model.dto.product.ProductResponseDTO;
import com.ra.model.entity.Product;
import com.ra.repository.ProductRepository;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> proEntity = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTO;
        productResponseDTO = proEntity.stream().map(
                product ->
                        ProductResponseDTO
                                .builder()
                                .id(product.getId())
                                .name(product.getProductName())
                                .price(product.getPrice())
                                .categoryName(product.getCategory().getCategoryName())
                                .image(product.getImage())
                                .build()
        ).toList();
        return productResponseDTO;
    }

    @Override
    public Page<ProductResponseDTO> pagination(Pageable pageable) {
        List<Product> proEntity = productRepository.findAll(pageable).getContent();
        List<ProductResponseDTO> productResponseDTO;
        productResponseDTO = proEntity.stream().map(
                product ->
                        ProductResponseDTO
                                .builder()
                                .id(product.getId())
                                .name(product.getProductName())
                                .price(product.getPrice())
                                .categoryName(product.getCategory().getCategoryName())
                                .image(product.getImage())
                                .build()
        ).toList();
        return new PageImpl<>(productResponseDTO, pageable, proEntity.size());
    }
}
