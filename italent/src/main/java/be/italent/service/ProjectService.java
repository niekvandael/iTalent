package be.italent.service;

import java.util.List;

import be.italent.model.Project;
import be.italent.model.User;

public interface ProjectService {
	public List<Project> getPublicProjects();
	public List<Project> getBackedProjects(int currentUserId);
	public List<Project> getAllProjects(int currentUserId);
	public List<Project> getAllUserProjects(User user);
	public List<Project> getMyLikedProjects(User user);
	public List<Project> getMySubscribedProjects(User user);
	public List<Project> getMyBackedProjects(User user);
	public Project getProjectById(int id, int currentUserId);
	public Project getProjectById(int id);
	public Project saveProject(Project project);
	public void deleteProject(int id);
}
