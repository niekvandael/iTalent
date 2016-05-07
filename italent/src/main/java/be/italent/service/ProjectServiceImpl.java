package be.italent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.Movie;
import be.italent.model.Picture;
import be.italent.model.Project;
import be.italent.model.User;
import be.italent.repository.ProjectRepo;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepo projectRepo;

    //Guest
    public List<Project> getPublicProjects() {
        return projectRepo.findAllByIsPublic(true);
    }
    
    //Student
    public List<Project> getBackedProjects() {
        return projectRepo.findAllByIsBacked(true);
    }
    
    //Docent
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
    
    //User created projects
    public List<Project> getAllUserProjects(User user) {
        return projectRepo.findUserProjects(user);
    }
    
    public List<Project> getMyLikedProjects(User user){
    	return projectRepo.findMyLikedProjects(user);
    }
    
    public List<Project> getMySubscribedProjects(User user){
    	return projectRepo.findMySubscribedProjects(user);
    }
    
    public List<Project> getMyBackedProjects(User user){
    	return projectRepo.findMyBackedProjects(user);
    }
    
    public Project getProjectById(int id){
        return projectRepo.findOne(id);			
    }
    
    public Project saveProject(Project project){
    	setChildData(project);
    	return projectRepo.save(project);	
    }
    
    public void deleteProject(int id){
    	projectRepo.delete(id);
    }

    
    private Project setChildData(Project project){
    	for (Movie movie : project.getMovies()){
    		movie.setProject(project);
    	}
    	
    	for (Picture picture : project.getPictures()){
    		picture.setProject(project);
    	}
    	
    	return project;
    }
}
