package be.italent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.SubscriberDocent;
import be.italent.repository.SubscriberDocentRepo;

@Service
public class SubscriberDocentServiceImpl implements SubscriberDocentService{

	 @Autowired
	 private SubscriberDocentRepo subscriberDocentRepo;
	 
	 public SubscriberDocent save(SubscriberDocent subscriberDocent){
    	return subscriberDocentRepo.save(subscriberDocent);	
    }
    
    public void delete(int id){
    	subscriberDocentRepo.delete(id);
    }
}
