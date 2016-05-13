package be.italent.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import be.italent.security.ITalentAuth;

@Data
@MappedSuperclass
public abstract class AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = 1446086446762595302L;
	
	public AbstractITalentEntity() {
		this.setStatus(this.getStatus());
		this.setLastUpdate(this.getLastUpdate());
		this.setLastUpdatedBy(this.getLastUpdatedBy());
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private Calendar lastUpdate;

	@Size(max = 50)
	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Size(max = 20)
	private String status;

	public Calendar getLastUpdate() {
		this.lastUpdate = Calendar.getInstance();
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdatedBy() {
		if(lastUpdatedBy == null){
			this.lastUpdatedBy = ITalentAuth.getAuthenticatedUser().getFirstname() + " " + ITalentAuth.getAuthenticatedUser().getLastname(); 
		}
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getStatus() {
		if(this.status == null){
			this.status = "A";
		}
		
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}