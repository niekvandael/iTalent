package be.italent.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public abstract class AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = 1446086446762595302L;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdate;

	@Size(max = 50)
	private String lastUpdatedBy;

	@Size(max = 20)
	private String status;
}
