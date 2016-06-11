//TODO not used

package be.italent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.italent.model.SubscriberStudent;
import be.italent.repository.SubscriberStudentRepo;

@Service
public class SubscriberStudentServiceImpl implements SubscriberStudentService{

	 @Autowired
	 private SubscriberStudentRepo subscriberStudentRepo;

	/**
	 * Save a {@like SubscriberStudent}
	 *
	 * @param subscriberStudent {@link SubscriberStudent} to be saved
	 * @return the saved {@link SubscriberStudent}
     */
	 public SubscriberStudent save(SubscriberStudent subscriberStudent){
    	return subscriberStudentRepo.save(subscriberStudent);	
    }

    /**
	 * Delete a selected {@link SubscriberStudent}
	 *
	 * @param id {@link int} id of the {@link SubscriberStudent} to be deleted
     */
    public void delete(int id){
    	subscriberStudentRepo.delete(id);
    }
}
