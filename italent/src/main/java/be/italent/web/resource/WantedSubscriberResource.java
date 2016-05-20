package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class WantedSubscriberResource extends ResourceSupport {
	@Mapping("id")
	private int wantedSubscriberId;
	private int number;
	private DepartmentResource department;
}