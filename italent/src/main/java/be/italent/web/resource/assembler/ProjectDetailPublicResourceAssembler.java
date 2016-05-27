package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectDetailPublicResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectDetailPublicResourceAssembler extends ResourceAssemblerSupport<Project, ProjectDetailPublicResource> {

    public ProjectDetailPublicResourceAssembler() {
        super(Project.class, ProjectDetailPublicResource.class);
    }

    @Override
    public ProjectDetailPublicResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectDetailPublicResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectDetailPublicResource.class);
        }
        return resource;
    }
}