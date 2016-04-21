package be.italent.interfaces;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class ITalentEntity implements Serializable{
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdate;

	@Size(max = 50)
	private String lastUpdatedBy;

	@Size(max = 20)
	private String status;

	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
