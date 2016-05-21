package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class WantedSubscriberResource extends ResourceSupport {
	private int wantedSubscriberId;
	private int number;
	private DepartmentResource department;
}