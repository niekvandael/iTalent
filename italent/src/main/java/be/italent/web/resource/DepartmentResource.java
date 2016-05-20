package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentResource extends ResourceSupport {
	@Mapping("id")
	private int departmentId;
	private String name;
}
