package ar.com.leogaray.relationship;

import ar.com.leogaray.relationship.manytomany.model.Course;
import ar.com.leogaray.relationship.manytomany.model.CourseRating;
import ar.com.leogaray.relationship.manytomany.model.Student;
import ar.com.leogaray.relationship.manytomany.repository.CourseRepository;
import ar.com.leogaray.relationship.manytomany.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class RelationshipApplication  implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RelationshipApplication.class);

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);

	}
	@Override
	public void run(String... args) {
		//Set<Course> listCourse = (Set<Course>) new ArrayList<Course>();
		Course course = new Course("Matematic");
		Course course2 = new Course("History");
		this.courseRepository.save(course);
		this.courseRepository.save(course2);

		Student student = new Student("Leo");
		Student student2 = new Student("Viv");
		student.addCourse(course);
		student.addCourse(course2);
		student2.addCourse(course2);

		CourseRating cr = new CourseRating(student,course,3);
		student.addRatings(cr);
		this.studentRepository.save(student);
		this.studentRepository.save(student2);
	}
}
