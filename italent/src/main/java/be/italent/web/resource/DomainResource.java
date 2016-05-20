package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class DomainResource extends ResourceSupport {
	@Mapping("id")
	private int domainId;
	private String name;
	private String description;
	private int MinimumHours;
	private int MaximumHours;
}
