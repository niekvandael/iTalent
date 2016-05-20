package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectMyBackedResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectMyBackedResourceAssembler extends ResourceAssemblerSupport<Project, ProjectMyBackedResource> {

    public ProjectMyBackedResourceAssembler() {
        super(Project.class, ProjectMyBackedResource.class);
    }

    @Override
    public ProjectMyBackedResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectMyBackedResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectMyBackedResource.class);
        }
        return resource;
    }
}