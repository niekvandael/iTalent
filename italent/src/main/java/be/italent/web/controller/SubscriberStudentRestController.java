package be.italent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.model.SubscriberStudent;
import be.italent.security.ITalentAuth;
import be.italent.service.SubscriberStudentService;

@RestController
@RequestMapping("/subscriberStudent")
public class SubscriberStudentRestController {

	@Autowired
	private SubscriberStudentService subscriberStudentService;
	
	@RequestMapping(value = "/save/{id}/{hours}", method = RequestMethod.POST, produces="application/json")
	public SubscriberStudent save(@PathVariable("id") final int id, @PathVariable("hours") final int hours){
	
		SubscriberStudent subscriberStudent = new SubscriberStudent();
		subscriberStudent.setUser(ITalentAuth.getAuthenticatedUser());
		subscriberStudent.setHours(hours);
		//TODO getproject(id) maybe?
		Project project = new Project();
		project.setId(id);
		subscriberStudent.setProject(project);
		
		return subscriberStudentService.save(subscriberStudent);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void delete(@PathVariable("id") final int id){
		subscriberStudentService.delete(id);
	}
}