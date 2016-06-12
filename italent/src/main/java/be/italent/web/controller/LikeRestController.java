package be.italent.web.controller;

import be.italent.service.LikeService;
import be.italent.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/likes")
public class LikeRestController {
    private static final Logger logger = LogManager.getLogger(LikeRestController.class.getName());

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
    @RequestMapping(value = "/likeProject", method = RequestMethod.POST, produces = "application/json")
    public boolean toggleLike(@RequestBody int projectId, Principal principal) {
        return likeService.toggleLike(projectId, userService.getUserByUsername(principal.getName()));
    }

}