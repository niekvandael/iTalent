package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectMyLikedResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectMyLikedResourceAssembler extends ResourceAssemblerSupport<Project, ProjectMyLikedResource> {

    public ProjectMyLikedResourceAssembler() {
        super(Project.class, ProjectMyLikedResource.class);
    }

    @Override
    public ProjectMyLikedResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectMyLikedResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectMyLikedResource.class);
        }
        return resource;
    }
}