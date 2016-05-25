package be.italent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.italent.model.Comment;
import be.italent.model.Project;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
	List<Comment> findAllByProject(Project project);

}
