package be.italent.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.model.SubscriberStudent;
import be.italent.service.SubscriberStudentService;
import be.italent.service.UserService;

@RestController
@RequestMapping("/subscriberStudent")
public class SubscriberStudentRestController {

	@Autowired
	private SubscriberStudentService subscriberStudentService;
	
	@Autowired
	private UserService userService;
	
	@Secured("Student")
	@RequestMapping(value = "/save/{id}/{hours}", method = RequestMethod.POST, produces="application/json")
	public SubscriberStudent save(@PathVariable("id") final int id, @PathVariable("hours") final int hours, Principal principal){
	
		SubscriberStudent subscriberStudent = new SubscriberStudent();
		subscriberStudent.setUser(userService.getUserByUsername(principal.getName()));
		subscriberStudent.setHours(hours);
		//TODO getproject(id) maybe?
		Project project = new Project();
		project.setId(id);
		subscriberStudent.setProject(project);
		
		return subscriberStudentService.save(subscriberStudent);
	}
	
	@Secured({"Docent", "Student"})
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void delete(@PathVariable("id") final int id){
		subscriberStudentService.delete(id);
	}
}