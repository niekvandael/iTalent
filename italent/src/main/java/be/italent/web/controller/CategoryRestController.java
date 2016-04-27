package be.italent.web.controller;

import java.util.List;

import be.italent.model.Category;
import be.italent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
}