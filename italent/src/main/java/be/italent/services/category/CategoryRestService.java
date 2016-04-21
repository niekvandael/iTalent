package be.italent.services.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryRestService {
	@Autowired
	private CategoryDao dao;

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ArrayList<Category> getCategories(){
		ArrayList<Category> c = (ArrayList<Category>) dao.getCategories();
		/*if(c == null){
			throw new CategoryNotFoundException("No Categories found");
		}*/
		return c;
	}
}