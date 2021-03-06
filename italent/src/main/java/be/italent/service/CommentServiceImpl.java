package be.italent.service;

import be.italent.model.Comment;
import be.italent.model.Project;
import be.italent.model.User;
import be.italent.repository.CommentRepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private static final Logger logger = LogManager.getLogger(CommentServiceImpl.class.getName());

    @Autowired
    private CommentRepo commentRepo;

    /**
     * Create a {@link Comment} for a specific {@link be.italent.model.Project}
     *
     * @param message   {@link String} the comment you wish to save
     * @param user      the {@link User} that has placed the comment
     * @param projectId {@link int} with the {@link be.italent.model.Project}.id you wish to save the comment for
     */
    @Override
    public void saveComment(String message, User user, int projectId) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- project: " + projectId);

        Comment comment = new Comment();
        comment.setITalentEntity(user.getUsername());
        comment.setMessage(message);

        Project project = new Project();
        project.setProjectId(projectId);

        comment.setProject(project);
        comment.setUser(user);

        commentRepo.save(comment);
    }

    /**
     * Retrieve a list with {@link Comment}s for a specifit {@link be.italent.model.Project}
     *
     * @param projectId {@link int} The id of the {@link be.italent.model.Project}
     * @return a {@link List} with {@link Comment}s
     */
    @Override
    public List<Comment> getComments(int projectId) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- project: " + projectId);

        Project project = new Project();
        project.setProjectId(projectId);
        return commentRepo.findAllByProject(project);
    }

    /**
     * Delete a specific {@link Comment}
     *
     * @param commentId {@link int} The id of the {@link Comment} to be deleted
     */
    @Override
    public void deleteComment(int commentId) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- comment: " + commentId);

        Comment comment = commentRepo.findOne(commentId);
        commentRepo.delete(comment);
    }
}