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

	/**
	 * Create a {@link Comment} for a specific {@link be.italent.model.Project}
	 *
	 * @param projectId {@link int} with the {@link be.italent.model.Project}.id you wish to save the comment for
	 * @param comment {@link Comment} thhe comment you wish to save
	 * @param principal {@link Principal}
     */
	@Secured({"Docent", "Student"})
	@RequestMapping(value = "/comments/save/{id}", method = RequestMethod.POST, produces="application/json")
	public void saveComment(@PathVariable("id") final int projectId, @RequestBody String comment, Principal principal){
		commentService.saveComment(comment, userService.getUserByUsername(principal.getName()), projectId);
	}

	/**
	 * Retrieve a list with {@link Comment}s for a specifit {@link be.italent.model.Project}
	 *
	 * @param projectId {@link int} The id of the {@link be.italent.model.Project}
	 * @return a {@link List} with {@link Comment}s
     */
	@Secured({"Docent", "Student"})
	@RequestMapping(value = "/comments/{id}", method = RequestMethod.GET, produces="application/json")
	public List<Comment> getComments(@PathVariable("id") final int projectId){
		return commentService.getComments(projectId);
	}

	/**
	 * Delete a specific {@link Comment}
	 *
	 * @param commentId {@link int} The id of the {@link Comment} to be deleted
     */
	@Secured({"Docent"})
	@RequestMapping(value = "/comments/remove/{id}", method = RequestMethod.DELETE, produces="application/json")
	public void deleteComment(@PathVariable("id") final int commentId){
		commentService.deleteComment(commentId);
	}
}