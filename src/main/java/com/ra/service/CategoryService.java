package com.ra.service;

import com.ra.model.dto.category.CategoryRequestDTO;
import com.ra.model.dto.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> getAllCategory();
    CategoryResponseDTO create(CategoryRequestDTO category);
    CategoryResponseDTO update(CategoryRequestDTO category,Long id);
    void delete(Long id);
    CategoryResponseDTO findById(Long id);

}
