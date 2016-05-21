package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectDetailResource extends ResourceSupport {
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
}
