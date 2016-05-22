package be.italent.service;

import java.util.List;

import be.italent.model.Project;
import be.italent.model.User;

public interface ProjectService {
	public List<Project> getPublicProjects();
	public List<Project> getBackedProjects(User currentUser);
	public List<Project> getAllProjects(User currentUser);
	public List<Project> getAllUserProjects(User user);
	public List<Project> getMyLikedProjects(User user);
	public List<Project> getMySubscribedProjects(User user);
	public List<Project> getMyBackedProjects(User user);
	public Project getProjectById(int id, User currentUser);
	public Project getProjectById(int id);
	public Project saveProject(Project project);
	public void deleteProject(int id);
}
