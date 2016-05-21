package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class MilestoneResource extends ResourceSupport {
	private int milestoneId;
	private boolean done;
	private String description;
}