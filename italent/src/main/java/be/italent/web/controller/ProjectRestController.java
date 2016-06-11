package be.italent.web.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.service.ProjectService;
import be.italent.service.UserService;
import be.italent.web.resource.ProjectListHomeResource;
import be.italent.web.resource.ProjectMyLikedResource;
import be.italent.web.resource.ProjectMySubscribedResource;
import be.italent.web.resource.ProjectUserResource;
import be.italent.web.resource.assembler.ProjectDetailDocentResourceAssembler;
import be.italent.web.resource.assembler.ProjectDetailPublicResourceAssembler;
import be.italent.web.resource.assembler.ProjectDetailStudentResourceAssembler;
import be.italent.web.resource.assembler.ProjectListHomeResourceAssembler;
import be.italent.web.resource.assembler.ProjectMyLikedResourceAssembler;
import be.italent.web.resource.assembler.ProjectMySubscribedResourceAssembler;
import be.italent.web.resource.assembler.ProjectUserResourceAssembler;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    private final static String DOCENT = "Docent";
    private final static String STUDENT = "Student";

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private ProjectListHomeResourceAssembler projectListHomeResourceAssembler;
    private ProjectDetailPublicResourceAssembler projectDetailPublicResourceAssembler;
    private ProjectDetailDocentResourceAssembler projectDetailDocentResourceAssembler;
    private ProjectDetailStudentResourceAssembler projectDetailStudentResourceAssembler;
    private ProjectUserResourceAssembler projectUserResourceAssembler;
    private ProjectMyLikedResourceAssembler projectMyLikedResourceAssembler;
    private ProjectMySubscribedResourceAssembler projectMySubscribedResourceAssembler;

    public ProjectRestController() {
        this.projectListHomeResourceAssembler = new ProjectListHomeResourceAssembler();
        this.projectDetailPublicResourceAssembler = new ProjectDetailPublicResourceAssembler();
        this.projectDetailDocentResourceAssembler = new ProjectDetailDocentResourceAssembler();
        this.projectDetailStudentResourceAssembler = new ProjectDetailStudentResourceAssembler();
        this.projectUserResourceAssembler = new ProjectUserResourceAssembler();
        this.projectMyLikedResourceAssembler = new ProjectMyLikedResourceAssembler();
        this.projectMySubscribedResourceAssembler = new ProjectMySubscribedResourceAssembler();
    }

    /**
     * Retrieve a list with {@link Project}s
     *
     * @param auth {@link Authentication}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     */
    @RequestMapping(value = "/listHome", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectListHomeResource>> getHomeProjects(Authentication auth) {
    	List<Project> projects = this.getProjectsForUser(auth);
    	Iterator<Project> it = projects.iterator();
    	
    	while(it.hasNext()) {
    	    Project proj = it.next();
    		if(proj.isArchived()){
    			it.remove();
    		}
    	}
    	return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(projects), HttpStatus.OK);
    }

    /**
     * Retrieve a list with archived {@link Project}s
     *
     * @param auth {@link Authentication}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     */
    @RequestMapping(value = "/listHomeArchive", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectListHomeResource>> getArchivedProjects(Authentication auth) {
    	List<Project> projects = this.getProjectsForUser(auth);
    	Iterator<Project> it = projects.iterator();
    	
    	while(it.hasNext()) {
    	    Project proj = it.next();
    		if(!proj.isArchived()){
    			it.remove();
    		}
    	}
    	return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(projects), HttpStatus.OK);
    }

    /**
     * Retrieve a list with running {@link Project}s
     *
     * @param auth {@link Authentication}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     *
     */
    @RequestMapping(value = "/listHomeRunning", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectListHomeResource>> getRunningProjects(Authentication auth) {
    	List<Project> projects = this.getProjectsForUser(auth);
    	Iterator<Project> it = projects.iterator();
    	
    	while(it.hasNext()) {
    	    Project proj = it.next();
    		if(!proj.isRunning()){
    			it.remove();
    		}
    	}
    	return new ResponseEntity<>(projectListHomeResourceAssembler.toResources(projects), HttpStatus.OK);
    }

    /**
     * Retrieve a list with {@link Project}s for the currently authenticated user based on role
     *
     * @param auth {@link Authentication}
     * @return {@link List} containing {@link Project}s
     *
     */
    private List<Project> getProjectsForUser(Authentication auth){
        if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority(STUDENT))) {
        	return projectService.getBackedProjects(userService.getUserByUsername(auth.getName()));
        } else if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority(DOCENT))) {
            return projectService.getAllProjects(userService.getUserByUsername(auth.getName()));
        } else {
        	return projectService.getPublicProjects();
        }
    }

    /**
     * Retrieve a list with {@link Project}s for the currently authenticated user
     *
     * @param principal {@link Principal}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     */
    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectUserResource>> getUserProjects(Principal principal) {
        return new ResponseEntity<>(projectUserResourceAssembler.toResources(
                projectService.getAllUserProjects(userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
    }

    /**
     * Retrieve a list with {@link Project}s liked by the currently authenticated user
     *
     * @param principal {@link Principal}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     */
    @Secured({"Docent", "Student"})
    @RequestMapping(value = "/myLiked", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProjectMyLikedResource>> getMyLikedProjects(Principal principal) {
        return new ResponseEntity<>(projectMyLikedResourceAssembler.toResources(
                projectService.getMyLikedProjects(userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
    }

    /**
     * Retrieve a list with {@link Project}s subscribed by the currently authenticated user
     *
     * @param auth {@link Authentication}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     */
    @Secured({"Student", "Docent"})
    @RequestMapping(value = "/mySubscribed", method = RequestMethod.GET, produces = "application/json")
        public ResponseEntity<List<ProjectMySubscribedResource>> getMySubscribedProjects(Authentication auth) {
    	
    	if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority(STUDENT))) {
    		return new ResponseEntity<>(projectMySubscribedResourceAssembler.toResources(
                    projectService.getMySubscribedProjects(userService.getUserByUsername(auth.getName()))), HttpStatus.OK);
        } 
    	else { // if role = docent...
        	return new ResponseEntity<>(projectMySubscribedResourceAssembler.toResources(
                    projectService.getMyBackedProjects(userService.getUserByUsername(auth.getName()))), HttpStatus.OK);
        }
    }

    /**
     * Retrieve a {@link Project} by authentication
     *
     * @param id {@link int} The id of the requested project
     * @param principal {@link Principal}
     * @return {@link ResponseEntity} containing a list of {@link Project}s and a {@link HttpStatus}.OK
     * @return One of the following:
     * <p>
     * - {@link HttpStatus}.OK and the {@link Project} that was requested
     * - {@link HttpStatus}.UNAUTHORIZED when the user is not authorized
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getProject(@PathVariable("id") final int id, Principal principal) {
        if (principal != null) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority(STUDENT))) {
                return new ResponseEntity<>(projectDetailStudentResourceAssembler
                        .toResource(projectService.getProjectById(id, userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
            } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority(DOCENT))) {
                return new ResponseEntity<>(projectDetailDocentResourceAssembler
                        .toResource(projectService.getProjectById(id, userService.getUserByUsername(principal.getName()))), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(projectDetailPublicResourceAssembler
                    .toResource(projectService.getProjectById(id)), HttpStatus.OK);
        }
    }

    /**
     * Retrieve a {@link Project} for editing
     *
     * @param id {@link int} The id of the requested project
     * @param principal {@link Principal}
     * @param auth {@link Authentication}
     * @return the requested {@link Project}
     */
    @Secured({DOCENT, STUDENT})
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = "application/json")
    public Project getEditProject(@PathVariable("id") final int id, Principal principal, Authentication auth) {
    	Project project = projectService.getProjectById(id, userService.getUserByUsername(principal.getName()));
    	
    	//prevent request manipulation, students can only edit their own projects and only when there are no backers yet
    	if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority(STUDENT))){
    		if(!project.getUser().getUsername().equals(principal.getName()) || project.getBackingPct()>0){
    			return null;
    		}
    	}
    	
    	return project;
    }

    /**
     * Save a specific {@link Project}
     *
     * @param project {@link Project}
     * @param principal {@link Principal}
     * @return the saved {@link Project}
     */
    @Secured({DOCENT, STUDENT})
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Project saveProject(@RequestBody Project project, Principal principal) {
    	
    	//prevent request manipulation, this method can only be used to save new projects
    	if (project.getProjectId() > 0){
    		return null;
    	}
    	
        project.setUser(userService.getUserByUsername(principal.getName()));
        return projectService.saveProject(project);
    }

    /**
     * Save a specific {@link Project}
     *
     * @param project {@link Project}
     * @param principal {@link Principal}
     * @return the saved {@link Project}
     */


    /**
     * Update a specific {@link Project}
     *
     * @param id {@link int} The id of the project to be updated
     * @param project {@link Project}
     * @param principal {@link Principal}
     * @param auth {@link Authentication}
     * @return the updated {@link Project}
     */
    @Secured({DOCENT, STUDENT})
    @RequestMapping(value = "/save/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Project updateProject(@PathVariable("id") final int id, @RequestBody Project project, Principal principal, Authentication auth) {
    	
    	//prevent request manipulation, students can only edit their own projects and only when there are no backers yet
    	if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority(STUDENT))){
    		if(!project.getUser().getUsername().equals(principal.getName()) || project.getBackingPct()>0){
    			return null;
    		}
    	}
    	
    	//when a subscriber is deleted after project is started reset start date...
    	if (project.getStartDate()!=null && project.getWantedSeats()>project.getTakenSeats()){
    		project.setStartDate(null);
    	}
    	
    	//when a supporter is deleted or changed update backingpct
    	project.updateBackingPct();
    	
        return projectService.saveProject(project);
    }

    /**
     * Delete a specific {@link Project}
     *
     * @param id {@link int} The id of the project to be deleted
     * @param principal {@link Principal}
     * @param auth {@link Authentication}
     */
    @Secured({DOCENT, STUDENT})
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = "application/json")
    public void deleteProject(@PathVariable("id") final int id, Principal principal, Authentication auth) {
    	
    	//prevent request manipulation, students can only delete their own projects and only when there are no backers yet
    	Project project = projectService.getProjectById(id, userService.getUserByUsername(principal.getName()));
    	if (auth != null && auth.getAuthorities().contains(new SimpleGrantedAuthority(STUDENT))){
    		if(!project.getUser().getUsername().equals(principal.getName()) || project.getBackingPct()>0){
    			return;
    		}
    	}
    	
        projectService.deleteProject(id);
    }
}