package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Data
@MappedSuperclass
public class Subscriber extends AbstractSubscriber implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}