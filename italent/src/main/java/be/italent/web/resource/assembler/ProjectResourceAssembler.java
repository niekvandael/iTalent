package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectSomeDetailsResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectResourceAssembler extends ResourceAssemblerSupport<Project, ProjectSomeDetailsResource> {

    public ProjectResourceAssembler() {
        super(Project.class, ProjectSomeDetailsResource.class);
    }

    @Override
    public ProjectSomeDetailsResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectSomeDetailsResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectSomeDetailsResource.class);
        }
        return resource;
    }
}