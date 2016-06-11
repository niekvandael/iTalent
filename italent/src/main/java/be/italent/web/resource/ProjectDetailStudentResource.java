package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import be.italent.model.Milestone;
import be.italent.model.OnlineFile;
import be.italent.model.Prezi;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectDetailStudentResource extends ResourceSupport {
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
	private List<OnlineFile> onlineFiles;
	private boolean canSubscribe;
	private int backingPct;
	private boolean isPublic;
    private List<CategoryResource> categories;
    private int mySubscribedHours;
}