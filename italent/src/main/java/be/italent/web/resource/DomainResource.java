package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

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
