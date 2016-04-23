package be.italent.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.interfaces.CategoryRepo;
import be.italent.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
	@Autowired
	private CategoryRepo dao;

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ArrayList<Category> getCategories(){
		ArrayList<Category> c = (ArrayList<Category>) dao.getCategories();

		return c;
	}
}