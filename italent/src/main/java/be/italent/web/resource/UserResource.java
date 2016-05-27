package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResource extends ResourceSupport {
    private int userId;
    private String firstname;
    private String lastname;
    private RoleResource role;
    private String email;
    private String username;
}