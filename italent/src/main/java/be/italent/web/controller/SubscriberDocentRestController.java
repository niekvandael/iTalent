package be.italent.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.model.SubscriberDocent;
import be.italent.service.SubscriberDocentService;
import be.italent.service.UserService;

@RestController
@RequestMapping("/subscriberDocent")
public class SubscriberDocentRestController {

	@Autowired
	private SubscriberDocentService subscriberDocentService;
	
	@Autowired
	private UserService userService;
	
	@Secured("Docent")
	@RequestMapping(value = "/save/{id}/{percentage}", method = RequestMethod.POST, produces="application/json")
	public SubscriberDocent save(@PathVariable("id") final int id, @PathVariable("percentage") final int percentage, Principal principal){
		System.out.println("test");
		SubscriberDocent subscriberDocent = new SubscriberDocent();
		subscriberDocent.setUser(userService.getUserByUsername(principal.getName()));
		subscriberDocent.setBackingPct(percentage);
		//TODO getproject(id) maybe?
		Project project = new Project();
		project.setId(id);
		subscriberDocent.setProject(project);
		
		return subscriberDocentService.save(subscriberDocent);
	}
	
	@Secured("Docent")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void delete(@PathVariable("id") final int id){
		subscriberDocentService.delete(id);
	}
}