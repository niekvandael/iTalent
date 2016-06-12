package be.italent.service;

import be.italent.model.Category;
import be.italent.repository.CategoryRepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class.getName());

    @Autowired
    private CategoryRepo categoryRepo;

    /**
     * Retrieve a list with {@link Category}s
     *
     * @return {@link List} containing {@link Category}s
     */
    public List<Category> getAllCategories() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        return categoryRepo.findAll();
    }

    /**
     * Create a {@link Category}
     *
     * @param category the {@link Category} to be saved
     * @return the saved {@link Category}
     */
    public Category createCategory(Category category) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- category: " + category.getCategoryId());

        return categoryRepo.save(category);
    }

    /**
     * Delete a specific {@link Category}
     *
     * @param id {@link int} The id of the {@link Category} to be deleted
     * @return {@link boolean} which tells if {@link Category} has been deleted
     */
    public boolean deleteCategory(int id) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- category: " + id);

        try {
            Category category = new Category();
            category.setCategoryId(id);
            categoryRepo.delete(category);
        } catch (Exception e) {
            logger.error(Thread.currentThread().getStackTrace()[1].getMethodName() + e.getMessage());

            return false;
        }
        return true;
    }
}
