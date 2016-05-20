package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectMySubscribedResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectMySubscribedResourceAssembler extends ResourceAssemblerSupport<Project, ProjectMySubscribedResource> {

    public ProjectMySubscribedResourceAssembler() {
        super(Project.class, ProjectMySubscribedResource.class);
    }

    @Override
    public ProjectMySubscribedResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectMySubscribedResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectMySubscribedResource.class);
        }
        return resource;
    }
}