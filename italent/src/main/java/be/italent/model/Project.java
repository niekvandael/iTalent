package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import be.italent.abstracts.AbstractITalentEntity;

@Entity
public class Project extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 6933862050829577662L;

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, max=100)
	private String title;
	
	@Size(max=100)
	private String omschrijving;
	
	@OneToOne
	private Category category;
	
	@OneToMany
	private List<Announcement> announcements = new ArrayList<Announcement>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((announcements == null) ? 0 : announcements.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((omschrijving == null) ? 0 : omschrijving.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (announcements == null) {
			if (other.announcements != null)
				return false;
		} else if (!announcements.equals(other.announcements))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (omschrijving == null) {
			if (other.omschrijving != null)
				return false;
		} else if (!omschrijving.equals(other.omschrijving))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
