package lab.spring.data.rest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {

	public Optional<Student> findByFirstName(String firstName);

}
