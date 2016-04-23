package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class WantedSubscriber extends AbstractSubscriber implements Serializable {
	private static final long serialVersionUID = 8161824845798470794L;

	private int number;
	
	@OneToOne
	private Department department;
}
