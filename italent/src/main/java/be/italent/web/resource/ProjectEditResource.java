// TODO Het lijkt me niet nodig om hier een resource voor te gebruiken.  Om te editeren kunnen we gewoon alles ophalen.


//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity getEditProject(@PathVariable("id") final int id, Principal principal) {
//        return new ResponseEntity<>(projectEditResourceAssembler
//                .toResource(projectService.getProjectById(id)), HttpStatus.OK);
//    }


/*package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectEditResource extends ResourceSupport {
	private Integer projectId;
	private String title;
	private String description;
	private String shortDescription;
	private Date creationDate;
	private UserResource user;
//		private int duration; //TODO
	private Date startDate;
	private CategoryResource category;
	private DomainResource domain;
	private boolean isPublic;
	private List<LikeResource> likes;
	private List<PictureResource> pictures;
	private List<MovieResource> movies;
	private List<MilestoneResource> milestones;
	private List<WantedSubscriberResource> wantedSubscribers;
	private List<SubscriberDocentResource> subscribersDocent;
	private List<SubscriberStudentResource> subscribersStudent;
	private List<PreziResource> prezis;
	private List<OnlineFileResource> onlineFiles;
	private List<CommentResource> comments;
	private int numberOfLikes;
	private boolean liked;
	private Integer backingPct;
}*/
