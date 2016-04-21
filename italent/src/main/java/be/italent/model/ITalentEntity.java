package be.italent.model;

import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class ITalentEntity {
	protected char status;
	@Size(max=55)
	protected String lastUpdatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	protected String lastUpdateTimestamp;
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
	public String getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
}
