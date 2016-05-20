package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class OnlineFileResource extends ResourceSupport {
	@Mapping("id")
	private int onlineFileId;
	private String url;
	private String description;
}