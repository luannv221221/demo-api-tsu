package com.ra.model.dto.product;

import com.ra.model.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.web.multipart.MultipartFile;

public class ProductRequestDTO {
    private String productName;
    private Double price;
    private MultipartFile image;
    private Long id;
}
