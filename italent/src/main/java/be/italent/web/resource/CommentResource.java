package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommentResource extends ResourceSupport {
	private int commentId;
	private String message;
	private UserResource user;
	private int parentCommentId;
}