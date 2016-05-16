package be.italent.web.controller;

import java.util.List;

import be.italent.model.Domain;
import be.italent.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Domain> getDomains() {
        return DomainService.getAllDomains();
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Domain createDomain(@RequestBody Domain Domain) {
        return DomainService.createDomain(Domain);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteDomain(@PathVariable("id") final int id) {
        return DomainService.deleteDomain(id);
    }
}