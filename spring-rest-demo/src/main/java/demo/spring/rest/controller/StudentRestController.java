package demo.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("kiran", "manam"));
		students.add(new Student("priya", "manam"));
		students.add(new Student("vihaan", "manam"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {

		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id Not found " + studentId);
		}
		return students.get(studentId);
	}

}
