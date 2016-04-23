package be.italent.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.italent.interfaces.ProjectRepo;
import be.italent.model.Project;

@Repository
public class ProjectRepoImpl implements ProjectRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public synchronized List<Project> getProjects() {
		
		TypedQuery<Project> query = em.createQuery("select p from Project as p order by p.id", Project.class);
	    return query.getResultList();
	}

}
