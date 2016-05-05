package be.italent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import be.italent.model.SubscriberStudent;
import be.italent.security.ITalentAuth;
import be.italent.service.SubscriberStudentService;

@RestController
@RequestMapping("/subscriberStudent")
public class SubscriberStudentRestController {

	@Autowired
	private SubscriberStudentService subscriberStudentService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
	public SubscriberStudent save(@RequestBody SubscriberStudent subscriberStudent){
		subscriberStudent.setUser(ITalentAuth.getAuthenticatedUser());
		
		return subscriberStudentService.save(subscriberStudent);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces="application/json")
	public void delete(@PathVariable("id") final int id){
		subscriberStudentService.delete(id);
	}
}