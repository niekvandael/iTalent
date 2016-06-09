package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Subscriber extends AbstractSubscriber implements Serializable  {
	private static final long serialVersionUID = 5217540830566245323L;
	
	@OneToOne
	@NotNull
	protected User user;
}