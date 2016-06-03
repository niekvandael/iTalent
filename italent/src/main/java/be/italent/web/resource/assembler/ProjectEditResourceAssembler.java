//TODO Not used

/*package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectEditResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectEditResourceAssembler extends ResourceAssemblerSupport<Project, ProjectEditResource> {

    public ProjectEditResourceAssembler() {
        super(Project.class, ProjectEditResource.class);
    }

    @Override
    public ProjectEditResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectEditResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectEditResource.class);
        }
        return resource;
    }
}*/