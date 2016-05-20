package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectUserResource extends ResourceSupport {
	@Mapping("id")
	private Integer projectId;
	private String title;
	private String description;
	private String shortDescription;
	private Date creationDate;
	private UserResource user;
	private Date startDate;
	private CategoryResource category;
	private DomainResource domain;
	private boolean isPublic;
	private List<PictureResource> pictures;
	private List<MovieResource> movies;
	private List<MilestoneResource> milestones;
	private List<WantedSubscriberResource> wantedSubscribers;
	private List<SubscriberDocentResource> subscribersDocent;
	private List<SubscriberStudentResource> subscribersStudent;
	private List<PreziResource> prezis;
	private List<OnlineFileResource> onlineFiles;
	private int numberOfLikes;
	private boolean liked;
	private boolean partiallyBacked;
}
