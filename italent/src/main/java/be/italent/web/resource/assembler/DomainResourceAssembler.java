package be.italent.web.resource.assembler;

import be.italent.model.Domain;
import be.italent.web.resource.DomainResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class DomainResourceAssembler extends ResourceAssemblerSupport<Domain, DomainResource> {

    public DomainResourceAssembler() {
        super(Domain.class, DomainResource.class);
    }

    @Override
    public DomainResource toResource(Domain entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        DomainResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, DomainResource.class);
        }
        return resource;
    }
}