package be.italent.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import be.italent.model.Project;
import be.italent.service.ProjectService;
import be.italent.service.UserService;
import be.italent.views.Views;
import be.italent.web.resource.assembler.ProjectResourceAssembler;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;

	private ProjectResourceAssembler projectResourceAssembler;

	public ProjectRestController() {
		this.projectResourceAssembler = new ProjectResourceAssembler();
	}

	@JsonView(Views.List.class)
	@RequestMapping(value = "/listHome", method = RequestMethod.GET, produces="application/json")
	public List<Project> getHomeProjects(Authentication auth){
		if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority("Student")))
			return (projectService.getBackedProjects());
		else if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority("Docent")))
			return projectService.getAllProjects();
		else
			return projectService.getPublicProjects();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces="application/json")
	public List<Project> getUserProjects(Principal principal){
		return projectService.getAllUserProjects(userService.getUserByUsername(principal.getName()));
	}
	
	@RequestMapping(value = "/myLiked", method = RequestMethod.GET, produces="application/json")
	public List<Project> getMyLikedProjects(Principal principal){
		return projectService.getMyLikedProjects(userService.getUserByUsername(principal.getName()));
	}
	
	@RequestMapping(value = "/mySubscribed", method = RequestMethod.GET, produces="application/json")
	public List<Project> getMySubscribedProjects(Principal principal){
		return projectService.getMySubscribedProjects(userService.getUserByUsername(principal.getName()));
	}
	
	@RequestMapping(value = "/myBacked", method = RequestMethod.GET, produces="application/json")
	public List<Project> getMyBackedProjects(Principal principal){
		return projectService.getMyBackedProjects(userService.getUserByUsername(principal.getName()));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public Project getProject(@PathVariable("id") final int id){
		return projectService.getProjectById(id);
	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
	public Project saveProject(@RequestBody Project project, Principal principal){
		project.setUser(userService.getUserByUsername(principal.getName()));
		return projectService.saveProject(project);
	}
	
	@RequestMapping(value = "/save/{id}", method = RequestMethod.PUT, produces="application/json")
	public Project updateProject(@PathVariable("id") final int id, @RequestBody Project project, Principal principal){
		return projectService.saveProject(project);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void deleteProject(@PathVariable("id") final int id){
		projectService.deleteProject(id);
	}
	
	/*@RequestMapping(value = "/description/{description}", method = RequestMethod.GET, produces="application/json")
	public List<Project> getProjectsByDescription(@PathVariable("description") final String description) {
		return projectService.getAllByDescription(description);
	}*/

	@RequestMapping(value = "/example/{id}", method = RequestMethod.GET)
	public ResponseEntity getAfterSalesFileWithNettoById(
			@PathVariable("id") final Integer id) {
		Project project =  projectService.getProjectById(id);

		if (project != null) {
			return new ResponseEntity<>(projectResourceAssembler.toResource(project), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}