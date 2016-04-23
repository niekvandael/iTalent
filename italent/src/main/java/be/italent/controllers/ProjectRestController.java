package be.italent.controllers;

import java.util.ArrayList;

import be.italent.model.Project;
import be.italent.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ArrayList<Project> getProjects(){
		System.out.println("GET");
		ArrayList<Project> project = (ArrayList<Project>) projectService.getAllProjects();
		
		return project;
	}

	@RequestMapping(value = " /description/{description}", method = RequestMethod.GET, produces="application/json")
	public ArrayList<Project> getProjectsByDescription(@PathVariable("description") final String description) {
		return (ArrayList<Project>) projectService.getAllByDescription(description);
	}
}