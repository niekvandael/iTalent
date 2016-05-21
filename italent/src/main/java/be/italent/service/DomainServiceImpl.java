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

    public List<Domain> getAllDomains() {
        return DomainRepo.findAll();
    }
    
    public Domain createDomain(Domain Domain){
    	return DomainRepo.save(Domain);
    }

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
