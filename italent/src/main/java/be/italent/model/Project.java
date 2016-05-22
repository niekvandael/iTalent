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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Project extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 4300509934424545336L;

	@Transient
	private boolean liked;

	@Id
	@GeneratedValue
	@Column(name="project_id")
	private int projectId;
	
	@Size(min=2, max=100)
	private String title;
	
	@Size(max=2000)
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
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "project_category", joinColumns = { 
			@JoinColumn(name = "project_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "category_id",  nullable = false, updatable = false) })
	private List<Category> categories = new ArrayList<Category>();
	
	@OneToOne
	private Domain domain;
	
	@Column(name="project_status")
	private int projectStatus;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="is_public")
	private boolean isPublic;	
	
	@OneToMany(mappedBy="project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
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
	
	@Transient
	private int backingPct;
	public int getBackingPct(){
		backingPct = 0;
		for (int i = 0; i < this.subscribersDocent.size(); i++) {
			backingPct += this.subscribersDocent.get(i).getBackingPct();
		}
		return backingPct;
	}
	
	@Transient
	private int wantedSeats;
	public int getWantedSeats(){
		wantedSeats = 0;
		for (int i = 0; i < this.getWantedSubscribers().size(); i++) {
			wantedSeats += this.getWantedSubscribers().get(i).getNumber();
		}
		return wantedSeats;
	}
	
	@Transient
	private int takenSeats;
	public int getTakenSeats(){
		takenSeats = 0;
		for (int i = 0; i < this.getSubscribersStudent().size(); i++) {
			takenSeats += 1;
		}
		return takenSeats;
	}
	
	@Transient
	private boolean canEnroll;
	
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
}