package be.italent.web.controller;

import java.util.List;

import be.italent.model.Domain;
import be.italent.service.DomainService;
import be.italent.web.resource.DomainResource;
import be.italent.web.resource.assembler.DomainResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domains")
public class DomainRestController {

    @Autowired
    private DomainService DomainService;

    private DomainResourceAssembler domainResourceAssembler;

    public DomainRestController() {
        this.domainResourceAssembler = new DomainResourceAssembler();
    }

    /**
     * Retrieve a list with {@link Domain}s
     *
     * @return {@link ResponseEntity} containing a list of {@link Domain}s and a {@link HttpStatus}.OK
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<DomainResource>> getDomains() {
        return new ResponseEntity<>(domainResourceAssembler.toResources(DomainService.getAllDomains()), HttpStatus.OK);
    }

    /**
     * Create a {@link Domain}
     * *
     * @param Domain the {@link Domain} to be saved
     * @return the saved {@link Domain}
     */
    @Secured("Docent")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Domain createDomain(@RequestBody Domain Domain) {
        return DomainService.createDomain(Domain);
    }

    /**
     * Delete a specific {@link Domain}
     *
     * @param id {@link int} The id of the {@link Domain} to be deleted
     * @return {@link boolean} which tells if {@link Domain} has been deleted
     */
    @Secured("Docent")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteDomain(@PathVariable("id") final int id) {
        return DomainService.deleteDomain(id);
    }
}