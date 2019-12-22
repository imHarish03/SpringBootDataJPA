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

		User user = new User("mithra", "m");
		Login login = new Login("Admins");

		login.setUser(user);

		loginDAO.save(login);
	}

	public void loadUser() {
		try {
			List<User> userList = userDAO.findAll();
			userList.forEach(System.out::println);

			Login login = loginDAO.findById(1).orElse(null);
			System.out.println(login);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
