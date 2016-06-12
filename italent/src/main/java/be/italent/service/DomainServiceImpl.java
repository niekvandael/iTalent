package be.italent.service;

import be.italent.model.Domain;
import be.italent.repository.DomainRepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceImpl implements DomainService {
    private static final Logger logger = LogManager.getLogger(DomainServiceImpl.class.getName());

    @Autowired
    private DomainRepo DomainRepo;

    /**
     * Retrieve a list with {@link Domain}s
     *
     * @return {@link List} containing {@link Domain}s
     */
    public List<Domain> getAllDomains() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        return DomainRepo.findAll();
    }

    /**
     * Create a {@link Domain}
     *
     * @param domain the {@link Domain} to be saved
     * @return the saved {@link Domain}
     */
    public Domain createDomain(Domain domain) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- domain: " + domain.getDomainId());

        return DomainRepo.save(domain);
    }

    /**
     * Delete a specific {@link Domain}
     *
     * @param id {@link int} The id of the {@link Domain} to be deleted
     * @return {@link boolean} which tells if {@link Domain} has been deleted
     */
    public boolean deleteDomain(int id) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- domain: " + id);

        try {
            Domain Domain = new Domain();
            Domain.setDomainId(id);
            DomainRepo.delete(Domain);
        } catch (Exception e) {
            logger.error(Thread.currentThread().getStackTrace()[1].getMethodName() + e.getMessage());

            return false;
        }
        return true;
    }
}
