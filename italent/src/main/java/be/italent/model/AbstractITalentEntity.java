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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private Calendar lastUpdate;

	@Size(max = 50)
	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Size(max = 20)
	private String status;
	
	public void setITalentEntity(String lastUpdatedBy, String status){
		this.setLastUpdate(Calendar.getInstance());
		this.setLastUpdatedBy(lastUpdatedBy);
		this.setStatus(status);
	}
}