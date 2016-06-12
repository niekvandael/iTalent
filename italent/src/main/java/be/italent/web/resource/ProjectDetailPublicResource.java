package be.italent.web.resource;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import be.italent.model.Milestone;
import be.italent.model.OnlineFile;
import be.italent.model.Prezi;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectDetailPublicResource extends ResourceSupport {
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
	private boolean isPublic;
    private List<CategoryResource> categories;
    private DomainResource domain;
}