package be.italent.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public abstract class AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = -5530760931727737943L;

	@Size(max = 1)
	private String status = "A";
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private Calendar lastUpdate = Calendar.getInstance();

	@Size(max = 55)
	@Column(name="last_updated_by")
	private String lastUpdatedBy = "Team 1";
	
	public void setITalentEntity(String lastUpdatedBy, String status){
		this.setLastUpdate(Calendar.getInstance());
		this.setLastUpdatedBy(lastUpdatedBy);
		this.setStatus(status);
	}
}