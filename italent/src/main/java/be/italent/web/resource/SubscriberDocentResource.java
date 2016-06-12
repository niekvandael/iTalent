package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class SubscriberDocentResource extends ResourceSupport {
	private int subscriberDocentId;
	private int backingPct;
	private UserResource user;
}