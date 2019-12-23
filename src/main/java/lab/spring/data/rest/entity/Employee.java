package lab.spring.data.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@IdClass(EmployeeAddress.class)
public class Employee {
	/*
	 * @EmbeddedId private EmployeeAddress address;
	 * 
	 */
	@Id
	private String streetName;

	@Id
	private String zipCode;

	private String firstName;

	public Employee() {

	}

	public Employee(String streetName, String zipCode, String firstName) {
		this.streetName = streetName;
		this.zipCode = zipCode;
		this.firstName = firstName;
	}

	/*
	 * public Employee(EmployeeAddress address, String firstName) { this.address =
	 * address; this.firstName = firstName; }
	 * 
	 * public EmployeeAddress getAddress() { return address; }
	 * 
	 * public void setAddress(EmployeeAddress address) { this.address = address; }
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
