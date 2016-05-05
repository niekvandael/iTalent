package be.italent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.italent.model.SubscriberStudent;
import be.italent.repository.SubscriberStudentRepo;
import be.italent.security.ITalentAuth;

@Service
public class SubscriberStudentServiceImpl implements SubscriberStudentService{

	 @Autowired
	 private SubscriberStudentRepo subscriberStudentRepo;
	 
	 public SubscriberStudent save(SubscriberStudent subscriberStudent){
    	subscriberStudent.setUser(ITalentAuth.getAuthenticatedUser());
    	return subscriberStudentRepo.save(subscriberStudent);	
    }
    
    public void delete(int id){
    	subscriberStudentRepo.delete(id);
    }
}
