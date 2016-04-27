package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class WantedSubscriber extends AbstractSubscriber implements Serializable {
	private static final long serialVersionUID = 8161824845798470794L;

	private int number;
	
	@OneToOne
	private Department department;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}