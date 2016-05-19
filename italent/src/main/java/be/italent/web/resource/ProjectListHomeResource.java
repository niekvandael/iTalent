package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectListHomeResource extends ResourceSupport {
    @Mapping("id")
    private Integer projectId;
    private String title;
    private String shortDescription;
    private Date creationDate;
    private UserResource user;
    private Date startDate;
    private CategoryResource category;
    private boolean isPublic;
    private List<PictureResource> pictures;
    private int numberOfLikes;
    private boolean liked;
}

