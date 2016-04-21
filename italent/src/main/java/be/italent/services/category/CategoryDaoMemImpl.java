package be.italent.services.category;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import be.italent.model.Category;

@Repository
public class CategoryDaoMemImpl implements CategoryDao {
	private Map<Integer, Category> categories;

	@PostConstruct
	public void init(){
	}
	
	public synchronized List<Category> getCategories() {
		//
		// TODO: Read this from database
		//
		List<Category> result = new ArrayList<Category>();
		
		Category cat1 = new Category();
		cat1.setId(1);
		cat1.setDescription("Category nr 1");
		cat1.setLastUpdate(Calendar.getInstance());
		cat1.setLastUpdatedBy("NIEK");
		cat1.setStatus("A");
		
		Category cat2 = new Category();
		cat2.setId(1);
		cat2.setDescription("Category nr 2");
		cat2.setLastUpdate(Calendar.getInstance());
		cat2.setLastUpdatedBy("NIEK");
		cat2.setStatus("A");
		
		result.add(cat1);
		result.add(cat2);
		
		return result;
	}

}
