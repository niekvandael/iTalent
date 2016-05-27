package be.italent.web.resource.assembler;

import be.italent.model.Project;
import be.italent.web.resource.ProjectDetailStudentResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectDetailStudentResourceAssembler extends ResourceAssemblerSupport<Project, ProjectDetailStudentResource> {

    public ProjectDetailStudentResourceAssembler() {
        super(Project.class, ProjectDetailStudentResource.class);
    }

    @Override
    public ProjectDetailStudentResource toResource(Project entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectDetailStudentResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectDetailStudentResource.class);
        }
        return resource;
    }
}