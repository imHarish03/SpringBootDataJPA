package lab.spring.data.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.UserDAO;
import lab.spring.data.rest.entity.EmergencyInfo;
import lab.spring.data.rest.entity.User;

@Service
public class OneToManyService {

	@Autowired
	private UserDAO userDAO;

	public void createEmergencyInfo() {
		try {
			User user = new User("Hari", "haran");

			EmergencyInfo emer1 = new EmergencyInfo("Latha", "8940005592");
			EmergencyInfo emer2 = new EmergencyInfo("Raja", "8940005592");

			user.addEmergencyInfo(emer2);
			user.addEmergencyInfo(emer1);

			userDAO.save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getUser() {
		try {
			User user = userDAO.findById(2).orElse(null);
			System.out.println(user.getFullName());
			System.out.println("List: " + user.getEmergencyInfo().size());

			for (EmergencyInfo info : user.getEmergencyInfo()) {
				System.out.println(info.getContactNumber());
				System.out.println(info.getContactPerson());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
