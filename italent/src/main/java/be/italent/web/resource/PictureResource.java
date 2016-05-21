package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class PictureResource extends ResourceSupport {
	@Mapping("id")
	private int pictureId;
    private String bytes;
    private String description;   
}