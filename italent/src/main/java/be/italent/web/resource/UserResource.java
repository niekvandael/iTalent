package be.italent.web.resource;

import be.italent.model.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResource extends ResourceSupport {
    private String firstname;
    private String lastname;
    private Role role;
}