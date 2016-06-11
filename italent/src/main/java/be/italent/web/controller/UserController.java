package be.italent.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

	/**
	 * Retrieve the current authorized user
	 *
	 * @param user {@link Principal}
	 * @return a {@link Principal} object containing the user info
     */
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
