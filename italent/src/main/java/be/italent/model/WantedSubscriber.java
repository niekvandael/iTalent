package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class WantedSubscriber extends AbstractSubscriber implements Serializable {
	private static final long serialVersionUID = 4731257726862062382L;

	private int number;
	
	@OneToOne
	private Department department;
}