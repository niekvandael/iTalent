package be.italent.service;

import be.italent.model.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.italent.repository.DomainRepo;

import java.util.List;

@Service
public class DomainServiceImpl implements DomainService{

    @Autowired
    private DomainRepo DomainRepo;

	/**
	 * Retrieve a list with {@link Domain}s
	 *
	 * @return {@link List} containing {@link Domain}s
     */
    public List<Domain> getAllDomains() {
        return DomainRepo.findAll();
    }

    /**
	 * Create a {@link Domain}
	 *
	 * @param Domain the {@link Domain} to be saved
	 * @return the saved {@link Domain}
     */
    public Domain createDomain(Domain Domain){
    	return DomainRepo.save(Domain);
    }

	/**
	 * Delete a specific {@link Domain}
	 *
	 * @param id {@link int} The id of the {@link Domain} to be deleted
	 * @return {@link boolean} which tells if {@link Domain} has been deleted
     */
    public boolean deleteDomain(int id){
    	try {
    		Domain Domain = new Domain();
    		Domain.setDomainId(id);
        	DomainRepo.delete(Domain);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
    	return true;
    }
}
