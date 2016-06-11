package be.italent.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.service.LikeService;
import be.italent.service.UserService;

@RestController
@RequestMapping("/likes")
public class LikeRestController {

	@Autowired
	private LikeService likeService;
	
	@Autowired
	private UserService userService;

	/**
	 * Toggles the likes status of a {@link be.italent.model.Project} for an authenticated user
	 *
	 * @param projectId {@link int} The id of the {@link be.italent.model.Project} to be (un)liked
	 * @param principal {@link Principal}
     * @return a {@link boolean} with the new liked value
     */
	@Secured({"Docent", "Student"})
	@RequestMapping(value = "/likeProject", method = RequestMethod.POST, produces="application/json")
	public boolean toggleLike(@RequestBody int projectId, Principal principal){
		return likeService.toggleLike(projectId, userService.getUserByUsername(principal.getName()));
	}
	
}