package lab.spring.data.rest.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	private String address;
	private String phone;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "contactFirstName")),
			@AttributeOverride(name = "lastName", column = @Column(name = "contactLastName")),
			@AttributeOverride(name = "phone", column = @Column(name = "contactPhone")) })
	private ContactPerson contactPerson;

	public Company() {

	}

	public Company(String name, String address, String phone, ContactPerson contactPerson) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.contactPerson = contactPerson;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", contactPerson="
				+ contactPerson + "]";
	}

}
