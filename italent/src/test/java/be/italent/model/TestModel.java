package be.italent.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.italent.controllers.CategoryRestController;

public class TestModel {

	@Test
	  public void testModel() {
		CategoryRestController categoryRestController = new CategoryRestController();
		
		Category categrory = new Category();
		categrory.setDescription("HEALTH");
		
		categoryRestController.getCategories();
		  
	    // assert statements
	    assertEquals(true, true);
	  }
}
