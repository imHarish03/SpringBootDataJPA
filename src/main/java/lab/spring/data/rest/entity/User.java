package lab.spring.data.rest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "FullName")
	private String fullName;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Login login;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<EmergencyInfo> emergencyInfo;

	public User() {

	}

	public User(String userName, String fullName) {
		this.userName = userName;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<EmergencyInfo> getEmergencyInfo() {
		return emergencyInfo;
	}

	public void setEmergencyInfo(List<EmergencyInfo> emergencyInfo) {
		this.emergencyInfo = emergencyInfo;
	}

	public void addEmergencyInfo(EmergencyInfo tempEmergencyInfo) {

		if (this.emergencyInfo == null) {
			this.emergencyInfo = new ArrayList<EmergencyInfo>();
		}
		this.emergencyInfo.add(tempEmergencyInfo);

		tempEmergencyInfo.setUser(this);
	}

}
