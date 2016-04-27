package be.italent.service;

import java.util.List;

import be.italent.model.Project;

public interface ProjectService {

	public List<Project> getAllProjects();
	public Project getProjectById(int id);
	public List<Project> getAllByDescription(String description);
}
