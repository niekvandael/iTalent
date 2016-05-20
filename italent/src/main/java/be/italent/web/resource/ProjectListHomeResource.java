package be.italent.web.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectListHomeResource extends ResourceSupport {
    @Mapping("id")
    private Integer projectId;
    private String title;
    private String shortDescription;
    private Date creationDate;
    private UserResource user;
    private Date startDate;
    private CategoryResource category;
    private boolean isPublic;
    private List<PictureResource> pictures;
    private int numberOfLikes;
    private boolean liked;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public UserResource getUser() {
		return user;
	}
	public void setUser(UserResource user) {
		this.user = user;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public CategoryResource getCategory() {
		return category;
	}
	public void setCategory(CategoryResource category) {
		this.category = category;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public List<PictureResource> getPictures() {
		return pictures;
	}
	public void setPictures(List<PictureResource> pictures) {
		this.pictures = pictures;
	}
	public int getNumberOfLikes() {
		return numberOfLikes;
	}
	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
}

