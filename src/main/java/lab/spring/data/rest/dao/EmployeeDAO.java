package lab.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
