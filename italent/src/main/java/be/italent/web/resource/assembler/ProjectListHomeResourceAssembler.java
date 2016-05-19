package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectListHomeResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectListHomeResourceAssembler extends ResourceAssemblerSupport<Project, ProjectListHomeResource> {

    public ProjectListHomeResourceAssembler() {
        super(Project.class, ProjectListHomeResource.class);
    }

    @Override
    public ProjectListHomeResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectListHomeResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectListHomeResource.class);
        }
        return resource;
    }
}