package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBaseResource extends ResourceSupport {

    private boolean liked;
    @Mapping("id")
    private Integer projectId;
    private String title;
    private String description;
    private String shortDescription;
    private Date creationDate;
}
