package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectUserResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectUserResourceAssembler extends ResourceAssemblerSupport<Project, ProjectUserResource> {

    public ProjectUserResourceAssembler() {
        super(Project.class, ProjectUserResource.class);
    }

    @Override
    public ProjectUserResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectUserResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectUserResource.class);
        }
        return resource;
    }
}