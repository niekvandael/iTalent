package be.italent.service;

import java.util.List;

import be.italent.model.Project;
import be.italent.model.User;

public interface ProjectService {
	public List<Project> getPublicProjects();
	public List<Project> getBackedProjects();
	public List<Project> getAllProjects();
	public List<Project> getAllUserProjects(User user);
	public List<Project> getMyLikedProjects(User user);
	public Project getProjectById(int id);
	public Project saveProject(Project project);
	public void deleteProject(int id);
}
