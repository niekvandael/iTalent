package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Subscriber extends AbstractSubscriber implements Serializable  {
	private static final long serialVersionUID = 5217540830566245323L;
	
	@OneToOne
	private User user;
}