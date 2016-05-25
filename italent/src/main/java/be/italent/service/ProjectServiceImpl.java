package be.italent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.Category;
import be.italent.model.Comment;
import be.italent.model.Like;
import be.italent.model.Milestone;
import be.italent.model.Movie;
import be.italent.model.OnlineFile;
import be.italent.model.Picture;
import be.italent.model.Prezi;
import be.italent.model.Project;
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
    public List<Project> getBackedProjects(User user) {
    	List<Project>  projects = projectRepo.findAllFullBackedProjects();
    	for (Project project : projects){
    		project.setLiked(user.getUserId());
    		project.setCanSubscribe(user.getUserId(), user.getDepartment().getDepartmentId()); //necessary for filter on home.html
    	}
    	return projects;
    }
    
    //Docent
    public List<Project> getAllProjects(User user) {
    	List<Project>  projects = projectRepo.findAll();
    	for (Project project : projects){
    		project.setLiked(user.getUserId());
    		//project.setCanBack(user.getUserId());
    	}
    	return projects;
    }
    
    //User created projects
    public List<Project> getAllUserProjects(User user) {
    	List<Project>  projects = projectRepo.findUserProjects(user);
    	if(projects.size()>0){
    		this.setIsLikedByCurrentUser(projects, user);
    	}
    	return projects;
    }
    
    public List<Project> getMyLikedProjects(User user){
    	List<Project>  projects = projectRepo.findMyLikedProjects(user);
    	if(projects.size()>0){
    		this.setIsLikedByCurrentUser(projects, user);
    	}
    	return projects;
    }
    
    public List<Project> getMySubscribedProjects(User user){
    	List<Project>  projects = projectRepo.findMySubscribedProjects(user);
    	if(projects.size()>0){
    		this.setIsLikedByCurrentUser(projects, user);
    	}
    	return projects;
    }
    
    public List<Project> getMyBackedProjects(User user){
    	List<Project>  projects = projectRepo.findMyBackedProjects(user);
    	if(projects.size()>0){
    		this.setIsLikedByCurrentUser(projects, user);
    	}
    	return projects;
    }
    
    public Project getProjectById(int id, User user){
    	//TODO Testing workaround for multiplication problem
        //return projectRepo.findOne(id);		
    	Project project =  projectRepo.findAllByProjectId(id).get(0);
    	project.setLiked(user.getUserId());
    	//TODO only if student
    	project.setCanSubscribe(user.getUserId(), user.getDepartment().getDepartmentId());
    	//TODO only if docent
    	project.setCanBack(user.getUserId());
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
    	for(Category category : project.getCategories()){
    		List<Project> projects = category.getProjects();
    		projects.add(project);
    		category.setProjects(projects);
    	}
    	
    	return project;
    }
    
    /*private void setTransientFields(List<Project> projects, User currentUser){
    	this.setIsLikedByCurrentUser(projects, currentUser);
    	this.setCanEnrollByCurrentUser(projects, currentUser);
    }*/
    
    private void setIsLikedByCurrentUser(List<Project> projects, User currentUser){
    	for (Project project : projects){
    		project.setLiked(currentUser.getUserId());
    	}
    }
    
    /*public void setCanEnrollByCurrentUser(List<Project> projects, User currentUser){
    	for(Project project : projects){
			int myDepartmentid = currentUser.getDepartment().getDepartmentId();
			
			// Check if there are available sets
			int takenSeats = project.getTakenSeats();
			int wantedSeats = project.getWantedSeats();
			
			if(wantedSeats == takenSeats){
				project.setCanEnroll(false);
			}
			
			// Check if my department asked
			int wantedInMyDepartment = 0;
			for (WantedSubscriber wantedSubscriber : project.getWantedSubscribers()) {
				if(wantedSubscriber.getDepartment().getDepartmentId() == myDepartmentid){
					wantedInMyDepartment = wantedSubscriber.getNumber();
					break;
				}
			}
	
			if(wantedInMyDepartment == 0){
				project.setCanEnroll(false);
			}
			
			int alreadyEnrolledInMyDepartment = 0;
			for(SubscriberStudent subscriberStudent : project.getSubscribersStudent()){
				if(subscriberStudent.getUser().getDepartment().getDepartmentId() == myDepartmentid){
					alreadyEnrolledInMyDepartment++;
				}
			}
	
			if(wantedInMyDepartment > alreadyEnrolledInMyDepartment){
				project.setCanEnroll(true);
			}
			
			project.setCanEnroll(false);
    	}
	}*/
}
