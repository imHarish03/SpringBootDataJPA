package lab.spring.data.rest.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@EmbeddedId
	private EmployeeAddress address;

	private String firstName;

	public Employee() {

	}

	public Employee(EmployeeAddress address, String firstName) {
		this.address = address;
		this.firstName = firstName;
	}

	public EmployeeAddress getAddress() {
		return address;
	}

	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
