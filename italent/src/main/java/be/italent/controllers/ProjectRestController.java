package be.italent.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.interfaces.ProjectRepo;
import be.italent.model.Project;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {
	@Autowired
	private ProjectRepo dao;

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ArrayList<Project> getProjects(){
		ArrayList<Project> c = (ArrayList<Project>) dao.getProjects();

		return c;
	}
}