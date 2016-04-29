package be.italent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.Like;
import be.italent.model.Project;
import be.italent.repository.LikeRepo;
import be.italent.security.ITalentAuth;

@Service
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeRepo likeRepo;

	@Override
	public boolean toggleLike(int projectId) {
		//
		// Create like object
		//
		Like l = new Like();
		l.setUser(ITalentAuth.getAuthenticatedUser());

		Project p = new Project();
		p.setId(projectId);
		
		l.setProject(p);
		
		
		//
		// Test if object exists (if not: create new like)
		//
		Like existingLike = likeRepo.getLikeByProject(l.getProject(), l.getUser());
		
		if(existingLike == null){
			// Already likes: unlike
			likeRepo.save(l);
			return true;
		} else{
			// Not likes yet: like
			likeRepo.delete(existingLike);
			return false;
		}
		
	}

    
}
