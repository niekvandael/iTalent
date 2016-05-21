package be.italent.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class AbstractSubscriber extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -6640010711471485773L;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.DETACH)
	private Project project;
}