package com.ra.controller;

import com.ra.model.dto.ResponseWrapper;
import com.ra.model.dto.product.ProductResponseDTO;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
//    @GetMapping("")
//    public ResponseEntity<?> findAll() {
//        List<ProductResponseDTO> productResponseDTOS = productService.findAll();
//        return ResponseEntity.ok(
//                ResponseWrapper.builder()
//                        .status(HttpStatus.OK)
//                        .code(200)
//                        .data(productResponseDTOS)
//                        .build()
//        );
//    }
    @GetMapping("")
    public ResponseEntity<?> findAll(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "limit",defaultValue = "2") int limit,
            @RequestParam(name = "sortBy",defaultValue = "price") String sortBy,
            @RequestParam(name = "orderBy",defaultValue = "asc") String orderBy
    ) {
        Sort sort = orderBy.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, limit,sort);
        Page<ProductResponseDTO> productResponseDTOS = productService.pagination(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTOS);
    }
}
