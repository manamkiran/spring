package demo.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showStudentForm(Model theModel) {

		theModel.addAttribute("student", new Student());
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("The Student:" + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
