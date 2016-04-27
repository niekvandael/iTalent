package be.italent.services;

import be.italent.model.Project;
import be.italent.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
    
    public Project getProjectById(int id){
        	return projectRepo.findOne(id);			
    }
    
    public List<Project> getAllByDescription(String description) {
        return projectRepo.findAllByDescription(description);
    }
}
