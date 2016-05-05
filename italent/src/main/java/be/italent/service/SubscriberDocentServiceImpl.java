package be.italent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.SubscriberDocent;
import be.italent.repository.SubscriberDocentRepo;
import be.italent.security.ITalentAuth;

@Service
public class SubscriberDocentServiceImpl implements SubscriberDocentService{

	 @Autowired
	 private SubscriberDocentRepo subscriberDocentRepo;
	 
	 public SubscriberDocent save(SubscriberDocent subscriberDocent){
    	subscriberDocent.setUser(ITalentAuth.getAuthenticatedUser());
    	return subscriberDocentRepo.save(subscriberDocent);	
    }
    
    public void delete(int id){
    	subscriberDocentRepo.delete(id);
    }
}
