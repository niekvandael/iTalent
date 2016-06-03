// TODO not used
/*package be.italent.web.resource.assembler;

import be.italent.model.Picture;
import be.italent.model.Project;
import be.italent.web.resource.ProjectMyBackedResource;

import java.util.ArrayList;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProjectMyBackedResourceAssembler extends ResourceAssemblerSupport<Project, ProjectMyBackedResource> {

    public ProjectMyBackedResourceAssembler() {
        super(Project.class, ProjectMyBackedResource.class);
    }

    @Override
    public ProjectMyBackedResource toResource(Project entity) {
    	// Only get first picture
    	if(entity.getPictures().size() > 1){
    		ArrayList<Picture> newList = new ArrayList<Picture>();
    		newList.add(entity.getPictures().get(0));
    		entity.setPictures(newList);
    	}
    	
    	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectMyBackedResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectMyBackedResource.class);
        }
        return resource;
    }
}*/