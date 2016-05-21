package be.italent.service;

import be.italent.model.Category;
import be.italent.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    
    public Category createCategory(Category category){
    	return categoryRepo.save(category);
    }

    public boolean deleteCategory(int id){
    	try {
    		Category category = new Category();
    		category.setCategoryId(id);
        	categoryRepo.delete(category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
    	return true;
    }
}
