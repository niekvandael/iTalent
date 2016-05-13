package be.italent.web.controller;

import java.security.Principal;
import java.util.List;

import be.italent.web.resource.assembler.ProjectResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	private ProjectResourceAssembler projectResourceAssembler;

	public ProjectRestController() {
		this.projectResourceAssembler = new ProjectResourceAssembler();
	}

	@RequestMapping(value = "/listHome", method = RequestMethod.GET, produces="application/json")
	public List<Project> getHomeProjects(Principal principal){
		if (principal != null) {
			System.out.println(principal.getName());
		}
		else  {
			System.out.println("Empty principal");
		}
		return projectService.getPublicProjects();
		//TODO send docent list if user has role docent
		//return projectService.getAllProjects();
		//TODO send student list if user has role student
		//return projectService.getBackedProjects());
	}
	
	//TODO remove when security works
	@RequestMapping(value = "/docent", method = RequestMethod.GET, produces="application/json")
	public List<Project> getProjects(){
		return projectService.getAllProjects();
	}
	
	//TODO remove when security works
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces="application/json")
	public List<Project> getBackedProjects(){
		return (projectService.getBackedProjects());
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces="application/json")
	public List<Project> getUserProjects(){
		return projectService.getAllUserProjects(ITalentAuth.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/myLiked", method = RequestMethod.GET, produces="application/json")
	public List<Project> getMyLikedProjects(){
		return projectService.getMyLikedProjects(ITalentAuth.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/mySubscribed", method = RequestMethod.GET, produces="application/json")
	public List<Project> getMySubscribedProjects(){
		return projectService.getMySubscribedProjects(ITalentAuth.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/myBacked", method = RequestMethod.GET, produces="application/json")
	public List<Project> getMyBackedProjects(){
		return projectService.getMyBackedProjects(ITalentAuth.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public Project getProject(@PathVariable("id") final int id){
		return (projectService.getProjectById(id));
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
	public Project saveProject(@RequestBody Project project){
		project.setUser(ITalentAuth.getAuthenticatedUser());
		return projectService.saveProject(project);
	}
	
	@RequestMapping(value = "/save/{id}", method = RequestMethod.PUT, produces="application/json")
	public Project updateProject(@PathVariable("id") final int id, @RequestBody Project project){
		project.setUser(ITalentAuth.getAuthenticatedUser());
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