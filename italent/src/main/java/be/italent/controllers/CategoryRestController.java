package be.italent.controllers;

import java.util.ArrayList;

import be.italent.model.Category;
import be.italent.services.CategoryService;
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
    public ArrayList<Category> getCategories() {
        ArrayList<Category> c = (ArrayList<Category>) categoryService.getAllCategories();

        return c;
    }
}