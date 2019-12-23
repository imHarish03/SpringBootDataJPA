package lab.spring.data.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.EmployeeDAO;
import lab.spring.data.rest.entity.Employee;
import lab.spring.data.rest.entity.EmployeeAddress;

@Service
public class CompositeService {

	@Autowired
	EmployeeDAO employeeDAO;

	public void createEmployee() {
		EmployeeAddress address = new EmployeeAddress("Crosscut", "56168");

		Employee employee = new Employee(address, "Hari");

		employeeDAO.save(employee);

	}

}
