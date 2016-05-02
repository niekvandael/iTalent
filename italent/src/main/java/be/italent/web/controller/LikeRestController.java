package be.italent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.service.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeRestController {

	@Autowired
	private LikeService likeService;

	@RequestMapping(value = "/likeProject", method = RequestMethod.POST, produces="application/json")
	public boolean toggleLike(@RequestBody int projectId){
		return likeService.toggleLike(projectId);
	}
	
}