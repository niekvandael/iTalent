//TODO not used

package be.italent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.SubscriberDocent;
import be.italent.repository.SubscriberDocentRepo;

@Service
public class SubscriberDocentServiceImpl implements SubscriberDocentService{

	 @Autowired
	 private SubscriberDocentRepo subscriberDocentRepo;

	/**
	 * Save a {@like SubscriberDocent}
	 *
	 * @param subscriberDocent {@link SubscriberDocent} to be saved
	 * @return the saved {@link SubscriberDocent}
	 */
	 public SubscriberDocent save(SubscriberDocent subscriberDocent){
    	return subscriberDocentRepo.save(subscriberDocent);	
    }

    /**
	 * Delete a selected {@link SubscriberDocent}
	 *
	 * @param id {@link int} id of the {@link SubscriberDocent} to be deleted
     */
    public void delete(int id){
    	subscriberDocentRepo.delete(id);
    }
}
