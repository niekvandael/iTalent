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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstname() {
		return userFirstname;
	}
	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}
	public String getUserLastname() {
		return userLastname;
	}
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	public String getUserLoginname() {
		return userLoginname;
	}
	public void setUserLoginname(String userLoginname) {
		this.userLoginname = userLoginname;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
