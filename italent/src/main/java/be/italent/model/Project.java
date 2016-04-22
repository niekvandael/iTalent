package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 6933862050829577662L;

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, max=100)
	private String title;
	
	@Size(max=1000)
	private String description;
	
	@Size(max=200)
	private String shortDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
	
	@OneToOne
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
	
	@OneToOne
	private Category category;
	
	private int projectStatus;
	
	private boolean isVerified;
	
	private boolean isPublic;
	
	@OneToMany(mappedBy="project")
	private List<Announcement> announcements = new ArrayList<Announcement>();
	
	@OneToMany(mappedBy="project")
	private List<Like> likes = new ArrayList<Like>();
	
	@OneToMany(mappedBy="project")
	private List<Milestone> milestones = new ArrayList<Milestone>();

	@OneToMany(mappedBy="project")
	private List<Movie> movies = new ArrayList<Movie>();
	
	@OneToMany(mappedBy="project")
	private List<Picture> pictures = new ArrayList<Picture>();
	
	@OneToMany(mappedBy="project")
	private List<WantedSubscriber> wantedSubscribers = new ArrayList<WantedSubscriber>();
	
	@OneToMany(mappedBy="project")
	private List<SubscriberStudent> subscribersStudent = new ArrayList<SubscriberStudent>();
	
	@OneToMany(mappedBy="project")
	private List<SubscriberDocent> subscribersDocent = new ArrayList<SubscriberDocent>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((announcements == null) ? 0 : announcements.hashCode());
		result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isPublic ? 1231 : 1237);
		result = prime * result + (isVerified ? 1231 : 1237);
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((milestones == null) ? 0 : milestones.hashCode());
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
		result = prime * result + ((pictures == null) ? 0 : pictures.hashCode());
		result = prime * result + projectStatus;
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((subscribersDocent == null) ? 0 : subscribersDocent.hashCode());
		result = prime * result + ((subscribersStudent == null) ? 0 : subscribersStudent.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((wantedSubscribers == null) ? 0 : wantedSubscribers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (announcements == null) {
			if (other.announcements != null)
				return false;
		} else if (!announcements.equals(other.announcements))
			return false;
		if (beginDate == null) {
			if (other.beginDate != null)
				return false;
		} else if (!beginDate.equals(other.beginDate))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (isPublic != other.isPublic)
			return false;
		if (isVerified != other.isVerified)
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (milestones == null) {
			if (other.milestones != null)
				return false;
		} else if (!milestones.equals(other.milestones))
			return false;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		if (pictures == null) {
			if (other.pictures != null)
				return false;
		} else if (!pictures.equals(other.pictures))
			return false;
		if (projectStatus != other.projectStatus)
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (subscribersDocent == null) {
			if (other.subscribersDocent != null)
				return false;
		} else if (!subscribersDocent.equals(other.subscribersDocent))
			return false;
		if (subscribersStudent == null) {
			if (other.subscribersStudent != null)
				return false;
		} else if (!subscribersStudent.equals(other.subscribersStudent))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (wantedSubscribers == null) {
			if (other.wantedSubscribers != null)
				return false;
		} else if (!wantedSubscribers.equals(other.wantedSubscribers))
			return false;
		return true;
	}
}
