package lab.spring.data.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lab.spring.data.rest.entity.User;
import lab.spring.data.rest.exception.RecordNotFoundException;
import lab.spring.data.rest.service.OneToOneUniService;

@RestController
public class UserController {
	@Autowired
	private OneToOneUniService service;

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable("id") int id) {
		User employee = service.loadUser(id);

		if (employee == null) {
			throw new RecordNotFoundException("Invalid employee id : " + id);
		}
		return new ResponseEntity<User>(employee, HttpStatus.OK);
	}
}
