package be.italent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.Like;
import be.italent.model.Milestone;
import be.italent.model.Movie;
import be.italent.model.Picture;
import be.italent.model.Prezi;
import be.italent.model.Project;
import be.italent.model.OnlineFile;
import be.italent.model.Comment;
import be.italent.model.SubscriberDocent;
import be.italent.model.SubscriberStudent;
import be.italent.model.User;
import be.italent.model.WantedSubscriber;
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
    public List<Project> getBackedProjects(int currentUserId) {
    	List<Project>  projects = projectRepo.findAllByIsBacked(true);
    	if(projects.size()>0){
    		setIsLikedByCurrentUser(projects, currentUserId);
    	}
    	return projects;
    }
    
    //Docent
    public List<Project> getAllProjects(int currentUserId) {
    	List<Project>  projects = projectRepo.findAll();
    	if(projects.size()>0){
    		setIsLikedByCurrentUser(projects, currentUserId);
    	}
    	return projects;
    }
    
    //User created projects
    public List<Project> getAllUserProjects(User user) {
    	List<Project>  projects = projectRepo.findUserProjects(user);
    	if(projects.size()>0){
    		setIsLikedByCurrentUser(projects, user.getUserId());
    	}
    	return projects;
    }
    
    public List<Project> getMyLikedProjects(User user){
    	List<Project>  projects = projectRepo.findMyLikedProjects(user);
    	if(projects.size()>0){
    		setIsLikedByCurrentUser(projects, user.getUserId());
    	}
    	return projects;
    }
    
    public List<Project> getMySubscribedProjects(User user){
    	List<Project>  projects = projectRepo.findMySubscribedProjects(user);
    	if(projects.size()>0){
    		setIsLikedByCurrentUser(projects, user.getUserId());
    	}
    	return projects;
    }
    
    public List<Project> getMyBackedProjects(User user){
    	List<Project>  projects = projectRepo.findMyBackedProjects(user);
    	if(projects.size()>0){
    		setIsLikedByCurrentUser(projects, user.getUserId());
    	}
    	return projects;
    }
    
    public Project getProjectById(int id, int currentUserId){
    	//TODO Testing workaround for multiplication problem
        //return projectRepo.findOne(id);		
    	Project project =  projectRepo.findAllByProjectId(id).get(0);
    	project.setLiked(currentUserId);
    	return project;
    }
    
    public Project getProjectById(int id){
    	//TODO Testing workaround for multiplication problem
        //return projectRepo.findOne(id);		
    	return projectRepo.findAllByProjectId(id).get(0);
    }
    
    public Project saveProject(Project project){
    	setChildData(project);
    	return projectRepo.save(project);	
    }
    
    public void deleteProject(int id){
    	projectRepo.delete(id);
    }
    
    private Project setChildData(Project project){
    	for(Like like : project.getLikes()){
    		like.setProject(project);
    	}
    	for(Milestone milestone : project.getMilestones()){
    		milestone.setProject(project);
    	}
    	for (Movie movie : project.getMovies()){
    		movie.setProject(project);
    	}
    	for (Picture picture : project.getPictures()){
    		picture.setProject(project);
    	}
    	for(WantedSubscriber wantedSubscriber : project.getWantedSubscribers()){
    		wantedSubscriber.setProject(project);
    	}
    	for(SubscriberStudent subscriberStudent : project.getSubscribersStudent()){
    		subscriberStudent.setProject(project);
    	}
    	for(SubscriberDocent subscriberDocent : project.getSubscribersDocent()){
    		subscriberDocent.setProject(project);
    	}
    	for(Prezi prezi : project.getPrezis()){
    		prezi.setProject(project);
    	}
    	for(OnlineFile onlineFile : project.getOnlineFiles()){
    		onlineFile.setProject(project);
    	}
    	for(Comment comment : project.getComments()){
    		comment.setProject(project);
    	}
    	
    	return project;
    }
    
    private void setIsLikedByCurrentUser(List<Project> projects, int currentUserId){
    	for (Project project : projects){
    		project.setLiked(currentUserId);
    	}
    }
}
