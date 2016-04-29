package be.italent.security;

import be.italent.model.User;

public class ITalentAuth {
	public static User getAuthenticatedUser(){
		User u = new User();
		u.setId(1);
		return u;
	}
}
