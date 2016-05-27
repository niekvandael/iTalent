package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectDetailDocentResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectDetailDocentResourceAssembler extends ResourceAssemblerSupport<Project, ProjectDetailDocentResource> {

    public ProjectDetailDocentResourceAssembler() {
        super(Project.class, ProjectDetailDocentResource.class);
    }

    @Override
    public ProjectDetailDocentResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectDetailDocentResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectDetailDocentResource.class);
        }
        return resource;
    }
}