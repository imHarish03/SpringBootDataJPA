package lab.spring.data.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.CourseDAO;
import lab.spring.data.rest.dao.StudentDAO;
import lab.spring.data.rest.entity.Course;
import lab.spring.data.rest.entity.Student;

@Service
public class ManyToManyService {

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private ManyToManyService manyToManyService;

	public void createStudent() {
		// Create more course
		Course tempCourse1 = new Course("Data Science");
		Course tempCourse2 = new Course("Atari 2600");
		Course tempCourse3 = new Course("Java 11");

		Student s1 = new Student("Hari", "haran", "123");
		Student s2 = new Student("Vinodh", "George", "george@123");
		Student s3 = new Student("Jeeva", "nanth", "jeeva@123");

		tempCourse1.addStudent(s1);
		tempCourse1.addStudent(s2);
		tempCourse2.addStudent(s2);
		tempCourse3.addStudent(s1);
		tempCourse2.addStudent(s3);

		List<Course> courseList = new ArrayList<Course>();
		courseList.add(tempCourse1);
		courseList.add(tempCourse2);
		courseList.add(tempCourse3);

		courseDAO.saveAll(courseList);

	}

	public void insertNewCourseForStudent() {
		try {
			manyToManyService.createStudent();

			Student tempStudent = studentDAO.findByFirstName("Hari").orElse(null);
			System.out.println("StudentID : " + tempStudent.getId());

			Course tempCourse2 = new Course("Python 2600");
			tempStudent.addCourse(tempCourse2);

			studentDAO.save(tempStudent);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void addExistingCourseForExistingStudent() {
		manyToManyService.createStudent();

		Student tempStudent = studentDAO.findByFirstName("Hari").orElse(null);
		System.out.println("StudentID : " + tempStudent.getId());

		Course course = courseDAO.findById(2).orElse(null);
		System.out.println("Course Name : " + course.getTitle());

		tempStudent.addCourse(course);

	}

}
