package lab.spring.data.rest.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	/*
	 * We use @ElementCollection annotation to declare an element-collection
	 * mapping. All the records of the collection are stored in a separate table.
	 * The configuration for this table is specified using the @CollectionTable
	 * annotation.
	 * 
	 * The @CollectionTable annotation is used to specify the name of the table that
	 * stores all the records of the collection, and the JoinColumn that refers to
	 * the primary table.
	 * 
	 * Moreover, When you’re using an Embeddable type with Element Collection, you
	 * can use the @AttributeOverrides and @AttributeOverride annotations to
	 * override/customize the fields of the embeddable type.
	 */
	@ElementCollection
	@CollectionTable(name = "company_location", joinColumns = @JoinColumn(name = "CompanyID"))
	@AttributeOverrides({ @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "street")) })
	private Set<Address> address;

	private String phone;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "contactFirstName")),
			@AttributeOverride(name = "lastName", column = @Column(name = "contactLastName")),
			@AttributeOverride(name = "phone", column = @Column(name = "contactPhone")) })
	private ContactPerson contactPerson;

	public Company() {

	}

	public Company(String name, Set<Address> address, String phone, ContactPerson contactPerson) {
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

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
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

}
