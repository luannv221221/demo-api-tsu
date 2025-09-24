package com.ra.service;

import com.ra.model.dto.product.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> findAll();
    Page<ProductResponseDTO> pagination (Pageable pageable);
}
