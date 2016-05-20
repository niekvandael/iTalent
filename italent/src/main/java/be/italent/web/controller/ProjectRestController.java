package be.italent.web.controller;

import be.italent.model.Project;
import be.italent.service.ProjectService;
import be.italent.service.UserService;
import be.italent.web.resource.ProjectListHomeResource;
import be.italent.web.resource.assembler.ProjectListHomeResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private ProjectListHomeResourceAssembler projectListHomeResourceAssembler;

    public ProjectRestController() {
        this.projectListHomeResourceAssembler = new ProjectListHomeResourceAssembler();
    }

    @RequestMapping(value = "/listHome", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectListHomeResource>> getHomeProjects(Authentication auth) {
        if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority("Student"))) {
            return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(
                    projectService.getBackedProjects(userService.getUserByUsername(auth.getName()).getId())), HttpStatus.OK);
        } else if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority("Docent"))) {
            return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(
                    projectService.getAllProjects(userService.getUserByUsername(auth.getName()).getId())), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(
                    projectService.getPublicProjects()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getUserProjects(Principal principal) {
        return projectService.getAllUserProjects(userService.getUserByUsername(principal.getName()));
    }

    @RequestMapping(value = "/myLiked", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getMyLikedProjects(Principal principal) {
        return projectService.getMyLikedProjects(userService.getUserByUsername(principal.getName()));
    }

    @RequestMapping(value = "/mySubscribed", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getMySubscribedProjects(Principal principal) {
        return projectService.getMySubscribedProjects(userService.getUserByUsername(principal.getName()));
    }

    @RequestMapping(value = "/myBacked", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getMyBackedProjects(Principal principal) {
        return projectService.getMyBackedProjects(userService.getUserByUsername(principal.getName()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Project getProject(@PathVariable("id") final int id, Principal principal) {
    	if (principal == null){
    		return projectService.getProjectById(id, 0);
    	}
    	else{
    		return projectService.getProjectById(id, userService.getUserByUsername(principal.getName()).getId());
    	}

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Project saveProject(@RequestBody Project project, Principal principal) {
        project.setUser(userService.getUserByUsername(principal.getName()));
        return projectService.saveProject(project);
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Project updateProject(@PathVariable("id") final int id, @RequestBody Project project, Principal principal) {
        return projectService.saveProject(project);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = "application/json")
    public void deleteProject(@PathVariable("id") final int id) {
        projectService.deleteProject(id);
    }
}