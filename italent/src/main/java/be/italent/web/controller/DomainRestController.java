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


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<DomainResource>> getDomains() {
        return new ResponseEntity<>(domainResourceAssembler.toResources(DomainService.getAllDomains()), HttpStatus.OK);
    }
    
    @Secured("Docent")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Domain createDomain(@RequestBody Domain Domain) {
        return DomainService.createDomain(Domain);
    }
    
    @Secured("Docent")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteDomain(@PathVariable("id") final int id) {
        return DomainService.deleteDomain(id);
    }
}