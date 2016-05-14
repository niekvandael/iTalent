package be.italent.service;

import be.italent.model.User;

public interface LikeService {
	public boolean toggleLike(int projectId, User user);
}
