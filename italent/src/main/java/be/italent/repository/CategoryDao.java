package be.italent.repository;

import java.util.List;

import be.italent.model.Category;

public interface CategoryDao {
	public List<Category> getCategories();
}
