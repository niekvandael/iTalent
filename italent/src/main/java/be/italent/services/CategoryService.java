package be.italent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.interfaces.CategoryInterface;
import be.italent.model.Category;
import be.italent.repo.CategoryRepo;

@Service
public class CategoryService implements CategoryInterface{

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    
    public CategoryService(CategoryRepo categoryRepo) {
    	this.categoryRepo = categoryRepo;
    }
}
