package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class PreziResource extends ResourceSupport {
	private int preziId;
	private String preziCode;
	private String description;
}