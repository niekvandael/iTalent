package be.italent.web.controller;

import java.util.List;

import be.italent.model.Category;
import be.italent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteCategory(@PathVariable("id") final int id) {
        return categoryService.deleteCategory(id);
    }
}