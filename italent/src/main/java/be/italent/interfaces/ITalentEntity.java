package be.italent.interfaces;

import java.util.Calendar;

public interface ITalentEntity {
	void setLastUpdate(Calendar lastUpdate);
	Calendar getLastUpdate();
	void setLastUpdatedBy(String lastUpdatedBy);
	String getLastUpdatedBy();
	void setStatus(String status);
	String getStatus();
}
