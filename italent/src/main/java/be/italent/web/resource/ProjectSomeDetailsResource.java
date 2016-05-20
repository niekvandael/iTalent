package be.italent.web.resource;

import be.italent.model.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectSomeDetailsResource extends ProjectBaseResource {

    @Mapping("user.id")
    private int userId;
    @Mapping("user.firstname")
    private String userFirstname;
    @Mapping("user.lastname")
    private String userLastname;
    @Mapping("user.role.name")
    private String userRole;
    @Mapping("user.department.name")
    private String userDepartment;
    @Mapping("user.username")
    private String userLoginname;

    private Date beginDate;
    private Date endDate;
    private Category category;
}
