package be.italent.service;

import java.util.List;

import be.italent.model.Category;

public interface CategoryService {
    public List<Category> getAllCategories();
    public Category createCategory(Category category);
    public boolean deleteCategory(int id);
}
