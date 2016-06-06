package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Project extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 4300509934424545336L;

	@Id
	@GeneratedValue
	@Column(name="project_id")
	private int projectId;
	
	@Size(min=2, max=75)
	@NotNull
	private String title;
	
	@Size(min=5, max=2000)
	@Lob
	@NotNull
	private String description;
	
	@Size(min=5, max=200)
	@NotNull
	@Column(name="short_description")
	private String shortDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
    private Date creationDate;
	
	@OneToOne
	@NotNull
	private User user;
	
	//in minutes
	@NotNull
	private int duration;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
    private Date startDate;
	
	@Transient
	private Date endDate;
	
	public Date getEndDate(){
		if (startDate == null || duration == 0){
			return null;
		}
		Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.MINUTE, duration);
        return cal.getTime();
	}
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "project_category", joinColumns = { 
			@JoinColumn(name = "project_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "category_id",  nullable = false, updatable = false) })
	private List<Category> categories = new ArrayList<Category>();
	
	@OneToOne
	private Domain domain;
	
	@Column(name="backing_pct")
	private int backingPct;
	
	@Column(name="is_public")
	private boolean isPublic;	
	
	@OneToMany(mappedBy="project")
	@JsonIgnore
	private List<Like> likes = new ArrayList<Like>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Milestone> milestones = new ArrayList<Milestone>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Movie> movies = new ArrayList<Movie>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Picture> pictures = new ArrayList<Picture>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<WantedSubscriber> wantedSubscribers = new ArrayList<WantedSubscriber>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<SubscriberStudent> subscribersStudent = new ArrayList<SubscriberStudent>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<SubscriberDocent> subscribersDocent = new ArrayList<SubscriberDocent>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Prezi> prezis = new ArrayList<Prezi>();
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<OnlineFile> onlineFiles = new ArrayList<OnlineFile>();
	
	@OneToMany(mappedBy="project")
	private List<Comment> comments = new ArrayList<Comment>();

	@Transient
	private boolean liked;
	
	@Transient
	private boolean archived;

	@Transient
	private boolean running;
	
	@Transient
	private int numberOfLikes;

	public int getNumberOfLikes(){
		return likes.size();
	}
	
	public void updateBackingPct(){
		int total = 0;
		for (int i = 0; i < this.subscribersDocent.size(); i++) {
			total += this.subscribersDocent.get(i).getBackingPct();
		}
		this.backingPct = total;
	}
	
	@Transient
	private int wantedSeats;
	public int getWantedSeats(){
		this.wantedSeats = 0;
		for (int i = 0; i < this.getWantedSubscribers().size(); i++) {
			this.wantedSeats += this.getWantedSubscribers().get(i).getNumber();
		}
		return this.wantedSeats;
	}
	
	@Transient
	private int takenSeats;
	public int getTakenSeats(){
		this.takenSeats = 0;
		for (int i = 0; i < this.getSubscribersStudent().size(); i++) {
			this.takenSeats += 1;
		}
		return this.takenSeats;
	}
	
	@Transient
	private boolean canSubscribe = false;
	
	public void updateCanSubscribe(int currentUserId, int departmentId){
		if (this.getWantedSeats()>this.getTakenSeats()){
			// Check amount asked in user department
			int wantedInMyDepartment = 0;
			for (WantedSubscriber wantedSubscriber : this.getWantedSubscribers()) {
				if(wantedSubscriber.getDepartment().getDepartmentId() == departmentId){
					wantedInMyDepartment = wantedSubscriber.getNumber();
					break;
				}
			}
			if(wantedInMyDepartment == 0){
				return;
			}
			int alreadyEnrolledInMyDepartment = 0;
			for(SubscriberStudent subscriberStudent : this.getSubscribersStudent()){
				if(subscriberStudent.getUser().getDepartment().getDepartmentId() == departmentId){
					//check if user is already subscribed
					if (subscriberStudent.getUser().getUserId() == currentUserId){
						return;
					}
					alreadyEnrolledInMyDepartment++;
				}
			}
			if(wantedInMyDepartment > alreadyEnrolledInMyDepartment){
				this.setCanSubscribe(true);
			}
		}
		else{
			return;
		}
	}
	
	@Transient
	private boolean canBack = false;
	
	public void updateCanBack(int currentUserId){
		
		// commented to allow backing after 100%
//		if (this.getBackingPct()>99){
//			return;
//		}
		
		// don't allow backing when project is running
		if (this.isRunning()){
			return;
		}
		
		//check if docent is already backing
		for(SubscriberDocent subscriberDocent : this.getSubscribersDocent()){
			if(subscriberDocent.getUser().getUserId() == currentUserId){
				return;
			}
		}
		this.setCanBack(true);
	}
	
	@JsonIgnore
	public void setLiked(int currentUserId) {
		this.liked = false;
		for (Like l : this.getLikes()) {
			if(l.getUser().getUserId() == currentUserId){
				this.liked = true;
				break;
			}
		}
	}
	
	@JsonIgnore
	public boolean isArchived() {
		if(this.startDate == null){
			return false;
		}
		
		Calendar date = dateToCalendar(this.startDate);
		long t= date.getTimeInMillis();
		Date endDate = new Date(t + (this.duration * 60000));
		
		if(endDate.compareTo(new Date()) < 0){
			this.archived = true;
		}
		
		return this.archived;
	}
	
	@JsonIgnore
	public boolean isRunning() {
		if(this.startDate == null){
			return false;
		}
		
		Calendar date = dateToCalendar(this.startDate);
		long t= date.getTimeInMillis();
		Date endDate = new Date(t + (this.duration * 60000));
		
		if(endDate.compareTo(new Date()) > 0){
			this.running = true;
		}
		
		return this.running;
	}
	
	private Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
}