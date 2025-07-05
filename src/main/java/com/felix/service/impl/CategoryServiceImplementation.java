package com.felix.service.impl;

import com.felix.dto.SalonDTO;
import com.felix.model.Category;
import com.felix.repository.CategoryRepository;
import com.felix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salon) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        newCategory.setImage(category.getImage());
        newCategory.setSalonId(salon.getId());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category == null) {
            throw new RuntimeException("Category not exist with id: " + id);
        }
        return category;
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findAllBySalonId(id);
    }

    @Override
    public void deleteCategoryById(Long id, Long salonId) throws Exception {
      Category category = getCategoryById(id);
      if(category.getSalonId().equals(salonId)) {
          throw new Exception("Category not exist with id: ");
      }
      categoryRepository.deleteById(id);
    }
}
