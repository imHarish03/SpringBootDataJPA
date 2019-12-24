package lab.spring.data.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.EmployeeDAO;
import lab.spring.data.rest.entity.Employee;

@Service
public class CompositeService {

	@Autowired
	EmployeeDAO employeeDAO;

	public void createEmployee() {
		// EmployeeAddress address = new EmployeeAddress("Crosscut1", "561628");

		Employee employee = new Employee("1st Street", "650061", "Hari");

		employeeDAO.save(employee);

	}

}
