package be.italent.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import be.italent.controllers.CategoryRestController;
import be.italent.repo.CategoryRepo;
import be.italent.services.CategoryService;

public class TestModel {

	@Autowired // dit is het probleem
	private CategoryRepo categoryRepo;
	
	@Test
	  public void testModel() {
		CategoryRestController categoryRestController = new CategoryRestController(new CategoryService(this.categoryRepo));
		
		Category categrory = new Category();
		categrory.setDescription("HEALTH");
		
		categoryRestController.getCategories();
		  
	    // assert statements
	    assertEquals(true, true);
	  }
}
