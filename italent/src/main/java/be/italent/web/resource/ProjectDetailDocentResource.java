package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import be.italent.model.Milestone;
import be.italent.model.Prezi;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectDetailDocentResource extends ResourceSupport {
    private Integer projectId;
	private String title;
	private List<PictureResource> pictures;
	private String description;
	private String shortDescription;
	private UserResource user;
	private Date startDate;
	private boolean liked;
	private int numberOfLikes;
	private List<MovieResource> movies;
	private List<Prezi> prezis;
	private List<Milestone> milestones;
	private List<WantedSubscriberResource> wantedSubscribers;
	private boolean canBack;
	private boolean running;
	private boolean isPublic;
}