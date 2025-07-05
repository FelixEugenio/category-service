package com.felix.service;

import com.felix.dto.SalonDTO;
import com.felix.model.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Category saveCategory(Category category, SalonDTO salon);
    Category getCategoryById(Long id);
    Set<Category> getAllCategoriesBySalon(Long id);
    void deleteCategoryById(Long id);

}
