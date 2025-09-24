package com.ra.controller;

import com.ra.model.dto.ResponseWrapper;
import com.ra.model.dto.category.CategoryRequestDTO;
import com.ra.model.dto.category.CategoryResponseDTO;
import com.ra.repository.CategoryRepository;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<CategoryResponseDTO> categoryResponseDTOS = categoryService.getAllCategory();
        return ResponseEntity.ok().body(
                ResponseWrapper.builder().status(HttpStatus.OK)
                        .code(200)
                        .data(categoryResponseDTOS).build()
        );
    }
    @PostMapping
    public ResponseEntity<?> addCategory(
            @RequestBody CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO categoryResponseDTO = categoryService.create(categoryRequestDTO);
        return ResponseEntity.ok().body(
                ResponseWrapper.builder().status(HttpStatus.CREATED)
                        .code(201).data(categoryResponseDTO).build()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CategoryResponseDTO categoryResponseDTO = categoryService.findById(id);
        return ResponseEntity.ok().body(ResponseWrapper.
                builder().status(HttpStatus.OK).code(200).
                data(categoryResponseDTO).build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO categoryResponseDTO = categoryService.update(categoryRequestDTO, id);
        return ResponseEntity.ok().body(
                ResponseWrapper.builder().status(HttpStatus.OK).code(200).data(categoryResponseDTO).build()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
//        return ResponseEntity.ok().body("Category has been deleted");
        return ResponseEntity.noContent().build();
    }
}
