package be.italent.web.controller;

import java.security.Principal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.model.SubscriberStudent;
import be.italent.service.ProjectService;
import be.italent.service.UserService;

@RestController
@RequestMapping("/subscriberStudent")
public class SubscriberStudentRestController {

	//@Autowired
	//private SubscriberStudentService subscriberStudentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Secured("Student")
	@RequestMapping(value = "/save/{id}/{hours}", method = RequestMethod.POST, produces="application/json")
	public void save(@PathVariable("id") final int id, @PathVariable("hours") final int hours, Principal principal){
		Project project = projectService.getProjectById(id, userService.getUserByUsername(principal.getName()));
		
		//prevent request manipulation, students can only subscribe to project if they haven't yet and if they are in the right department
		if(!project.isCanSubscribe()){
			return;
		}
		
		SubscriberStudent subscriberStudent = new SubscriberStudent();
		subscriberStudent.setUser(userService.getUserByUsername(principal.getName()));
		subscriberStudent.setHours(hours);
		subscriberStudent.setProject(project);
		project.getSubscribersStudent().add(subscriberStudent);
		
		//when 100% subscribed set project start date to now
		if (project.getWantedSeats()>0 && project.getWantedSeats()-project.getTakenSeats()<1){
			project.setStartDate(Calendar.getInstance().getTime());
		}
		
		projectService.saveProject(project);
	}
	
	/*@Secured({"Docent", "Student"})
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void delete(@PathVariable("id") final int id){
		//TODO update project start/end date (if needed) if we allow subscribe delete else remove this method
		subscriberStudentService.delete(id);
	}*/
}