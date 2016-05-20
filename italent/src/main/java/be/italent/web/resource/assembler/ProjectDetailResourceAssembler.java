package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectDetailResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectDetailResourceAssembler extends ResourceAssemblerSupport<Project, ProjectDetailResource> {

    public ProjectDetailResourceAssembler() {
        super(Project.class, ProjectDetailResource.class);
    }

    @Override
    public ProjectDetailResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectDetailResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectDetailResource.class);
        }
        return resource;
    }
}