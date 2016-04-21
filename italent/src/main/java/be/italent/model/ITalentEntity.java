package be.italent.model;

import javax.validation.constraints.Size;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //slightly more normalized 
public abstract class ITalentEntity {
	@Id
	@GeneratedValue
	protected long id;
	
	
	protected char status;
	@Size(max=55)
	protected String lastUpdatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastUpdateTimestamp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
	
}
