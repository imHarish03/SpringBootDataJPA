package lab.spring.data.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.LoginDAO;
import lab.spring.data.rest.dao.UserDAO;
import lab.spring.data.rest.entity.Login;
import lab.spring.data.rest.entity.User;

@Service
public class OneToOneUniService {

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private UserDAO userDAO;

	public void createUser() {

		User user = new User("Gomathi", "VM.Gomathi");
		Login login = new Login("GHOAMRAI");

		login.setUser(user);

		loginDAO.save(login);
	}

	public void loadUserList() {
		try {
			List<User> userList = userDAO.findAll();
			userList.forEach(System.out::println);

			Login login = loginDAO.findById(1).orElse(null);
			System.out.println(login);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public User loadUser(int id) {
		return null;
	}
	
	
	

}
