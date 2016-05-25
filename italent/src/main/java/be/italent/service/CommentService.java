package be.italent.service;

import java.util.List;

import be.italent.model.Comment;
import be.italent.model.User;

public interface CommentService {
	public void saveComment(String comment, User user, int projectId);
	public List<Comment> getComments(int projectId);
}
