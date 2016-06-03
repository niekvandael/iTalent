package be.italent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.Comment;
import be.italent.model.Project;
import be.italent.model.User;
import be.italent.repository.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepo commentRepo;

	@Override
	public void saveComment(String message, User user, int projectId) {
		Comment comment = new Comment();
		comment.setMessage(message);
		
		Project project = new Project();
		project.setProjectId(projectId);
		
		comment.setProject(project);
		comment.setUser(user);
		
		commentRepo.save(comment);
	}

	@Override
	public List<Comment> getComments(int projectId) {
		Project project = new Project();
		project.setProjectId(projectId);
		return commentRepo.findAllByProject(project);
	}

	@Override
	public void deleteComment(int commentId) {
		Comment comment = commentRepo.findOne(commentId);
		commentRepo.delete(comment);
		
		// List<Comment> cmts = this.getComments(comment.getProject().getProjectId()); TODO ?
		
	}
}