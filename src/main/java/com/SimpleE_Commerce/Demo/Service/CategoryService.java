package com.SimpleE_Commerce.Demo.Service;

import com.SimpleE_Commerce.Demo.DTO.CategoryDTO;
import com.SimpleE_Commerce.Demo.Entity.Category;
import com.SimpleE_Commerce.Demo.Repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    categoryRepository categoryRepository;

    public List<CategoryDTO> findAll() {

        return categoryRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    public CategoryDTO findById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return convertToDTO(category);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
    public void deleteById(int id) {
        categoryRepository.deleteById(id);

    }
    // ---- Converters ----

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    private Category convertToEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }

}
