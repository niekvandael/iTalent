package be.italent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Project;
import be.italent.model.SubscriberDocent;
import be.italent.security.ITalentAuth;
import be.italent.service.SubscriberDocentService;

@RestController
@RequestMapping("/subscriberDocent")
public class SubscriberDocentRestController {

	@Autowired
	private SubscriberDocentService subscriberDocentService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
	public SubscriberDocent save(@RequestBody int id){
		
		SubscriberDocent subscriberDocent = new SubscriberDocent();
		subscriberDocent.setUser(ITalentAuth.getAuthenticatedUser());
		
		//TODO
		//subscriberStudent.setHours(hours);
		//TODO getproject(id) maybe?
		Project project = new Project();
		project.setId(id);
		subscriberDocent.setProject(project);
		
		return subscriberDocentService.save(subscriberDocent);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void delete(@PathVariable("id") final int id){
		subscriberDocentService.delete(id);
	}
}