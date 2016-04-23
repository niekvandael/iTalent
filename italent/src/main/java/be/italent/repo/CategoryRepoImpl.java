package be.italent.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.italent.interfaces.CategoryRepo;
import be.italent.model.Category;

@Repository
public class CategoryRepoImpl implements CategoryRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public synchronized List<Category> getCategories() {
		
		TypedQuery<Category> query = em.createQuery("select c from Category as c order by c.description", Category.class);
	    return query.getResultList();
	}

}
