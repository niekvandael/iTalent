package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Project extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 6933862050829577662L;
	
	@Transient
	private boolean liked;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, max=100)
	private String title;
	
	@Size(max=1000)
	@Lob
	private String description;
	
	@Size(max=200)
	@Column(name="short_description")
	private String shortDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
    private Date creationDate;
	
	@OneToOne
	private User user;
	
	private int duration;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
    private Date startDate;
	
	@OneToOne
	private Category category;
	
	@OneToOne
	private Domain domain;
	
	@Column(name="project_status")
	private int projectStatus;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="is_public")
	private boolean isPublic;
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Announcement> announcements = new ArrayList<Announcement>();
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Like> likes = new ArrayList<Like>();
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Milestone> milestones = new ArrayList<Milestone>();

	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Movie> movies = new ArrayList<Movie>();
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Picture> pictures = new ArrayList<Picture>();
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<WantedSubscriber> wantedSubscribers = new ArrayList<WantedSubscriber>();
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SubscriberStudent> subscribersStudent = new ArrayList<SubscriberStudent>();
	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SubscriberDocent> subscribersDocent = new ArrayList<SubscriberDocent>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Prezi> prezis = new ArrayList<Prezi>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OnlineFile> onlineFiles = new ArrayList<OnlineFile>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comment> Comments = new ArrayList<Comment>();

	@Transient
	private int numberOfLikes;
	//Don't delete this getter
	public int getNumberOfLikes(){
		return likes.size();
	}
	
	//TODO Testen
	//Een student kan een project verwijderen zolang er nog niemand gebacked heeft
	//misschien status voor gebruiken?
	@Transient
	private boolean partiallyBacked;
	//Don't delete this getter
	public boolean isPartiallybacked(){
		return subscribersDocent.size()>0;
	}
	
	//@Transient
	@Column(name="is_backed")
	private boolean isBacked;
	//Don't delete this getter
	//TODO TEST
	public boolean isBacked() {
		int total = 0;
		for(SubscriberDocent s : subscribersDocent){
			total += s.getBackingPct();
		}
		return total > 99;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<WantedSubscriber> getWantedSubscribers() {
		return wantedSubscribers;
	}

	public void setWantedSubscribers(List<WantedSubscriber> wantedSubscribers) {
		this.wantedSubscribers = wantedSubscribers;
	}

	public List<SubscriberStudent> getSubscribersStudent() {
		return subscribersStudent;
	}

	public void setSubscribersStudent(List<SubscriberStudent> subscribersStudent) {
		this.subscribersStudent = subscribersStudent;
	}

	public List<SubscriberDocent> getSubscribersDocent() {
		return subscribersDocent;
	}

	public void setSubscribersDocent(List<SubscriberDocent> subscribersDocent) {
		this.subscribersDocent = subscribersDocent;
	}
	
	public List<Prezi> getPrezis() {
		return prezis;
	}

	public void setPrezis(List<Prezi> prezis) {
		this.prezis = prezis;
	}

	public List<OnlineFile> getOnlineFiles() {
		return onlineFiles;
	}

	public void setOnlineFiles(List<OnlineFile> onlineFiles) {
		this.onlineFiles = onlineFiles;
	}

	public List<Comment> getComments() {
		return Comments;
	}

	public void setComments(List<Comment> comments) {
		Comments = comments;
	}

	public boolean isLiked() {
		this.liked = false;
		for (Like l : this.getLikes()) {
			//TODO
			//if(l.getUser().getId() == ITalentAuth.getAuthenticatedUser().getId()){
			if(l.getUser().getId() == 1){
				this.setLiked(true);
				break;
			}
		}
		return this.liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}
}