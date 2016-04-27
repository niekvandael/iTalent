package be.italent.web.controller;

import java.util.List;

import be.italent.model.Project;
import be.italent.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/italent/ws/projects")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public List<Project> getProjects(){
		System.out.println("GET");
		return projectService.getAllProjects();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public Project getProject(@PathVariable("id") final int id){
		System.out.println("GET PROJECT" + id);
		return projectService.getProjectById(id);
	}

	@RequestMapping(value = "/description/{description}", method = RequestMethod.GET, produces="application/json")
	public List<Project> getProjectsByDescription(@PathVariable("description") final String description) {
		return projectService.getAllByDescription(description);
	}
}