package lab.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.spring.data.rest.entity.Course;

public interface CourseDAO extends JpaRepository<Course, Integer> {

}
