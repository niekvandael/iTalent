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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
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
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<Announcement> announcements = new ArrayList<Announcement>();
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<Like> likes = new ArrayList<Like>();
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<Milestone> milestones = new ArrayList<Milestone>();

	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<Movie> movies = new ArrayList<Movie>();
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<Picture> pictures = new ArrayList<Picture>();
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<WantedSubscriber> wantedSubscribers = new ArrayList<WantedSubscriber>();
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<SubscriberStudent> subscribersStudent = new ArrayList<SubscriberStudent>();
	
	@JsonBackReference
	@OneToMany(mappedBy="project")
	private List<SubscriberDocent> subscribersDocent = new ArrayList<SubscriberDocent>();
}
