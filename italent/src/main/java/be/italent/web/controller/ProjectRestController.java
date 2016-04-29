package be.italent.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.security.ITalentAuth;
import be.italent.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/public", method = RequestMethod.GET, produces="application/json")
	public List<Project> getPublicProjects(){
		return projectService.getPublicProjects();
	}
	
	@RequestMapping(value = "/docent", method = RequestMethod.GET, produces="application/json")
	public List<Project> getProjects(){
		return projectService.getAllProjects();
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces="application/json")
	public List<Project> getBackedProjects(){
		return (projectService.getBackedProjects());
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces="application/json")
	public List<Project> getUserProjects(){
		return projectService.getAllUserProjects(ITalentAuth.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public Project getProject(@PathVariable("id") final int id){
		return (projectService.getProjectById(id));
	}
	/*@RequestMapping(value = "/description/{description}", method = RequestMethod.GET, produces="application/json")
	public List<Project> getProjectsByDescription(@PathVariable("description") final String description) {
		return projectService.getAllByDescription(description);
	}*/
}