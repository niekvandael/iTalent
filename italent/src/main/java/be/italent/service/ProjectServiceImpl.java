package be.italent.service;

import be.italent.model.*;
import be.italent.repository.ProjectRepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static final Logger logger = LogManager.getLogger(ProjectServiceImpl.class.getName());

    @Autowired
    private ProjectRepo projectRepo;

    /**
     * Retrieve a list with all public {@link Project}s
     *
     * @return {@link List} containing {@link Project}s
     */
    //Guest
    public List<Project> getPublicProjects() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        return projectRepo.findAllByIsPublic(true);
    }

    /**
     * Retrieve a list with all backed {@link Project}s for a specific {@link User}
     *
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return {@link List} containing {@link Project}s
     */
    //Student
    public List<Project> getBackedProjects(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() + " " + user.getLastname());

        List<Project> projects = projectRepo.findAllFullBackedProjects();
        for (Project project : projects) {
            project.setLiked(user.getUserId());
            project.setMyBackingPct(user.getUserId());
            project.setMySubscribedHours(user.getUserId());
            project.updateCanSubscribe(user.getUserId(), user.getDepartment().getDepartmentId()); //necessary for filter on home.html
        }
        return projects;
    }

    /**
     * Retrieve a list with all {@link Project}s with info per {@link User}
     *
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return {@link List} containing {@link Project}s
     */
    //Docent
    public List<Project> getAllProjects(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() + " " + user.getLastname());

        List<Project> projects = projectRepo.findAll();
        for (Project project : projects) {
            project.setLiked(user.getUserId());
            project.setMyBackingPct(user.getUserId());
            project.setMySubscribedHours(user.getUserId());
            project.updateCanBack(user.getUserId()); //necessary for filter on home.html
        }
        return projects;
    }

    /**
     * Retrieve a list with {@link Project}s created by the currently authenticated user
     *
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return {@link List} containing {@link Project}s
     */
    //User created projects
    public List<Project> getAllUserProjects(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() + " " + user.getLastname());

        List<Project> projects = projectRepo.findUserProjects(user);
        if (projects.size() > 0) {
            this.setIsLikedByCurrentUser(projects, user);
            this.setBackingPctByCurrentUser(projects, user);
            this.setSubscribedHoursByCurrentUser(projects, user);
        }
        return projects;
    }

    /**
     * Retrieve a list with {@link Project}s liked by the currently authenticated user
     *
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return {@link List} containing {@link Project}s
     */
    public List<Project> getMyLikedProjects(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() + " " + user.getLastname());

        List<Project> projects = projectRepo.findMyLikedProjects(user);
        if (projects.size() > 0) {
            this.setIsLikedByCurrentUser(projects, user);
            this.setBackingPctByCurrentUser(projects, user);
            this.setSubscribedHoursByCurrentUser(projects, user);
        }
        return projects;
    }

    /**
     * Retrieve a list with {@link Project}s subscribed by the currently authenticated user
     *
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return {@link List} containing {@link Project}s
     */
    public List<Project> getMySubscribedProjects(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() + " " + user.getLastname());

        List<Project> projects = projectRepo.findMySubscribedProjects(user);
        if (projects.size() > 0) {
            this.setIsLikedByCurrentUser(projects, user);
            this.setBackingPctByCurrentUser(projects, user);
            this.setSubscribedHoursByCurrentUser(projects, user);
        }
        return projects;
    }

    /**
     * Retrieve a list with {@link Project}s backed by the currently authenticated user
     *
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return {@link List} containing {@link Project}s
     */
    public List<Project> getMyBackedProjects(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() + " " + user.getLastname());

        List<Project> projects = projectRepo.findMyBackedProjects(user);
        if (projects.size() > 0) {
            this.setIsLikedByCurrentUser(projects, user);
            this.setBackingPctByCurrentUser(projects, user);
            this.setSubscribedHoursByCurrentUser(projects, user);
        }
        return projects;
    }

    /**
     * Retrieve a {@link Project} by id for the currently authenticated user
     *
     * @param id   {@link int} project id
     * @param user the {@link User} you wish to retrieve the {@link Project}s for
     * @return a {@link Project}
     */
    public Project getProjectById(int id, User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " + user.getFirstname() +
                " " + user.getLastname() + " / project: " + id);

        Project project = projectRepo.findOneByProjectId(id);
        project.setLiked(user.getUserId());
        project.setMyBackingPct(user.getUserId());
        project.setMySubscribedHours(user.getUserId());

        if (user.getRole().getName().equals("Student")) {
            project.updateCanSubscribe(user.getUserId(), user.getDepartment().getDepartmentId());
        } else { //if role is docent...
            project.updateCanBack(user.getUserId());
        }
        return project;
    }

    /**
     * Retrieve a {@link Project} by id
     *
     * @param id {@link int} project id
     * @return a {@link Project}
     */
    public Project getProjectById(int id) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- project: " + id);

        return projectRepo.findOneByProjectId(id);
    }

    /**
     * Create/save a {@link Project}
     *
     * @param project the {@link Project} to be saved
     * @return a {@link Project}
     */
    public Project saveProject(Project project, String user){
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- project: " + project.getProjectId() + 
        		" / user: " + user);

    	project.setITalentEntity(user);
    	setChildData(project);
    	return projectRepo.save(project);	
    }

    /**
     * Delete a specific {@link Project}
     *
     * @param id {@link int} The id of the {@link Project} to be deleted
     */
    public void deleteProject(int id) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- project: " + id);

        projectRepo.delete(id);
    }

    /**
     * set the data for a {@link Project} that is about to be saved
     *
     * @param project the {@link Project} containing the data
     * @return a {@link Project}
     */
    private Project setChildData(Project project) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- project: " + project.getProjectId());

        for (Like like : project.getLikes()) {
            like.setProject(project);
        }
        for (Milestone milestone : project.getMilestones()) {
            milestone.setProject(project);
        }
        for (Movie movie : project.getMovies()) {
            movie.setProject(project);
        }
        for (Picture picture : project.getPictures()) {
            picture.setProject(project);
        }
        for (WantedSubscriber wantedSubscriber : project.getWantedSubscribers()) {
            wantedSubscriber.setProject(project);
        }
        for (SubscriberStudent subscriberStudent : project.getSubscribersStudent()) {
            subscriberStudent.setProject(project);
        }
        for (SubscriberDocent subscriberDocent : project.getSubscribersDocent()) {
            subscriberDocent.setProject(project);
        }
        for (Prezi prezi : project.getPrezis()) {
            prezi.setProject(project);
        }
        for (OnlineFile onlineFile : project.getOnlineFiles()) {
            onlineFile.setProject(project);
        }
        for (Comment comment : project.getComments()) {
            comment.setProject(project);
        }
        for (Category category : project.getCategories()) {
            List<Project> projects = category.getProjects();
            projects.add(project);
            category.setProjects(projects);
        }
        return project;
    }

    /**
     * Set values per {@link Project}s if they are like by selected {@link User}
     *
     * @param projects    {@link List} of {@link Project}s to be checked
     * @param currentUser {@link User} on which to base the check on
     */
    private void setIsLikedByCurrentUser(List<Project> projects, User currentUser) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " +
                currentUser.getFirstname() + " " + currentUser.getLastname());

        for (Project project : projects) {
            project.setLiked(currentUser.getUserId());
        }
    }

    /**
     * Set backing percentage per {@link Project}s by selected {@link User}
     *
     * @param projects    {@link List} of {@link Project}s to be checked
     * @param currentUser {@link User} on which to base the check on
     */
    private void setBackingPctByCurrentUser(List<Project> projects, User currentUser) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " +
                currentUser.getFirstname() + " " + currentUser.getLastname());

        for (Project project : projects) {
            project.setMyBackingPct(currentUser.getUserId());
        }
    }

    /**
     * Set subscribed hours per {@link Project}s by selected {@link User}
     *
     * @param projects    {@link List} of {@link Project}s to be checked
     * @param currentUser {@link User} on which to base the check on
     */
    private void setSubscribedHoursByCurrentUser(List<Project> projects, User currentUser) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- user: " +
                currentUser.getFirstname() + " " + currentUser.getLastname());

        for (Project project : projects) {
            project.setMySubscribedHours(currentUser.getUserId());
        }
    }
}
