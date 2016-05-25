package be.italent.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Comment;
import be.italent.service.CommentService;
import be.italent.service.UserService;

@RestController
public class CommentRestController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;

	@Secured({"Docent", "Student"})
	@RequestMapping(value = "/comments/save/{id}", method = RequestMethod.POST, produces="application/json")
	public void saveComment(@PathVariable("id") final int projectId, @RequestBody String comment, Principal principal){
		commentService.saveComment(comment, userService.getUserByUsername(principal.getName()), projectId);
	}
	
	@Secured({"Docent", "Student"})
	@RequestMapping(value = "/comments/{id}", method = RequestMethod.GET, produces="application/json")
	public List<Comment> saveComment(@PathVariable("id") final int projectId){
		return commentService.getComments(projectId);
	}
}