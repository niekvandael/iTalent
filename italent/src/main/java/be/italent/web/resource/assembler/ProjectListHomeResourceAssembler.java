package be.italent.web.resource.assembler;

import java.util.ArrayList;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import be.italent.model.Picture;
import be.italent.model.Project;
import be.italent.web.resource.ProjectListHomeResource;

public class ProjectListHomeResourceAssembler extends ResourceAssemblerSupport<Project, ProjectListHomeResource> {

    public ProjectListHomeResourceAssembler() {
        super(Project.class, ProjectListHomeResource.class);
    }

    @Override
    public ProjectListHomeResource toResource(Project entity) {
    	// Only get first picture
    	if(entity.getPictures().size() > 1){
    		ArrayList<Picture> newList = new ArrayList<Picture>();
    		newList.add(entity.getPictures().get(0));
    		entity.setPictures(newList);
    	}
    	
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        ProjectListHomeResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, ProjectListHomeResource.class);
        }
        return resource;
    }
}