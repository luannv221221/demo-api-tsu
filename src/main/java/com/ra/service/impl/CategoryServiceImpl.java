package com.ra.service.impl;

import com.ra.model.dto.category.CategoryRequestDTO;
import com.ra.model.dto.category.CategoryResponseDTO;
import com.ra.model.entity.Category;
import com.ra.repository.CategoryRepository;
import com.ra.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponseDTO> getAllCategory() {
      List<Category> categories = categoryRepository.findAll();
      List<CategoryResponseDTO> categoryResponseDTOS;
      categoryResponseDTOS = categories.stream().
              map(category -> CategoryResponseDTO.
              builder()
                              .id(category.getId())
                              .categoryName(category.getCategoryName())
                              .build()
              ).toList();

      return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO category) {
        Category categoryNew = Category.builder()
                .categoryName(category.getName())
                .build();
        Category categoryEntity = categoryRepository.save(categoryNew);
        return CategoryResponseDTO.builder()
                .id(categoryEntity.getId())
                .categoryName(categoryEntity.getCategoryName())
                .build();
    }

    @Override
    public CategoryResponseDTO update(CategoryRequestDTO category,Long id) {
        // lay ve doi tuong can update
        Category categoryUpdate = categoryRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User Not found"));
        // set cac thong nguoi dung muon cap nhat
        categoryUpdate.setCategoryName(category.getName());

        Category categoryEntity = categoryRepository.save(categoryUpdate);
        return CategoryResponseDTO.builder()
                .id(categoryEntity.getId())
                .categoryName(categoryEntity.getCategoryName())
                .build();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category categoryEntity = categoryRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User Not found"));
        return CategoryResponseDTO.builder()
                .id(categoryEntity.getId())
                .categoryName(categoryEntity.getCategoryName())
                .build();
    }
}
