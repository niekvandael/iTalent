package be.italent.web.controller;

import be.italent.model.Project;
import be.italent.service.ProjectService;
import be.italent.service.UserService;
import be.italent.web.resource.*;
import be.italent.web.resource.assembler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    private ProjectDetailResourceAssembler projectDetailResourceAssembler;
    private ProjectUserResourceAssembler projectUserResourceAssembler;
    private ProjectMyLikedResourceAssembler projectMyLikedResourceAssembler;
    private ProjectMySubscribedResourceAssembler projectMySubscribedResourceAssembler;
    private ProjectMyBackedResourceAssembler projectMyBackedResourceAssembler;

    public ProjectRestController() {
        this.projectListHomeResourceAssembler = new ProjectListHomeResourceAssembler();
        this.projectDetailResourceAssembler = new ProjectDetailResourceAssembler();
        this.projectUserResourceAssembler = new ProjectUserResourceAssembler();
        this.projectMyLikedResourceAssembler = new ProjectMyLikedResourceAssembler();
        this.projectMySubscribedResourceAssembler = new ProjectMySubscribedResourceAssembler();
        this.projectMyBackedResourceAssembler = new ProjectMyBackedResourceAssembler();
    }

    @RequestMapping(value = "/listHome", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectListHomeResource>> getHomeProjects(Authentication auth) {
        if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority("Student"))) {
            return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(
                    projectService.getBackedProjects(userService.getUserByUsername(auth.getName()).getUserId())), HttpStatus.OK);
        } else if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority("Docent"))) {
            return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(
                    projectService.getAllProjects(userService.getUserByUsername(auth.getName()).getUserId())), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(
                    projectService.getPublicProjects()), HttpStatus.OK);
        }
    }

    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectUserResource>> getUserProjects(Principal principal) {
        return new ResponseEntity<>(projectUserResourceAssembler.toResources(
                projectService.getAllUserProjects(userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
    }

    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/myLiked", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectMyLikedResource>> getMyLikedProjects(Principal principal) {
        return new ResponseEntity<>(projectMyLikedResourceAssembler.toResources(
                projectService.getMyLikedProjects(userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
    }

    @Secured("Student")
    @RequestMapping(value = "/mySubscribed", method = RequestMethod.GET, produces = "application/json")
        public ResponseEntity<List<ProjectMySubscribedResource>> getMySubscribedProjects(Principal principal) {
        return new ResponseEntity<>(projectMySubscribedResourceAssembler.toResources(
                projectService.getMySubscribedProjects(userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
    }

    @Secured("Docent")
    @RequestMapping(value = "/myBacked", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectMyBackedResource>> getMyBackedProjects(Principal principal) {
        return new ResponseEntity<>(projectMyBackedResourceAssembler.toResources(
                projectService.getMyBackedProjects(userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
    }

    //TODO opsplitsen in docent/studen/public/save/update detail
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<ProjectDetailResource> getProject(@PathVariable("id") final int id, Principal principal) {
//    	if (principal == null){
//            return new ResponseEntity<>(projectDetailResourceAssembler
//                    .toResource(projectService.getProjectById(id, 0)), HttpStatus.OK);
//    	}
//    	else {
//            return new ResponseEntity<>(projectDetailResourceAssembler
//                    .toResource(projectService.getProjectById(id, userService.getUserByUsername(principal.getName()).getUserId())), HttpStatus.OK);
//    	}
//    }
    
    //TODO: Tijdelijk... (anders werkt het opslaan niet) zie todo hierboven...
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Project getProject(@PathVariable("id") final int id, Principal principal) {
    	if (principal == null){
            return projectService.getProjectById(id, 0);
    	}
    	else {
            return projectService.getProjectById(id, userService.getUserByUsername(principal.getName()).getUserId());
    	}
    }

    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Project saveProject(@RequestBody Project project, Principal principal) {
        project.setUser(userService.getUserByUsername(principal.getName()));
        return projectService.saveProject(project);
    }

    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/save/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Project updateProject(@PathVariable("id") final int id, @RequestBody Project project, Principal principal) {
        return projectService.saveProject(project);
    }

    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = "application/json")
    public void deleteProject(@PathVariable("id") final int id) {
        projectService.deleteProject(id);
    }
}