package be.italent.service;

import java.util.List;

import be.italent.model.Domain;

public interface DomainService {
    public List<Domain> getAllDomains();
    public Domain createDomain(Domain Domain);
    public boolean deleteDomain(int id);
}
