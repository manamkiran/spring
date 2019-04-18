package demo.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showMyForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("processFormVersionTwo")
	public String UpperCaseName(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");

		name = name.toUpperCase();

		model.addAttribute("message", "Yo " + name);

		return "helloworld";
	}

	@RequestMapping("processFormVersionThree")
	public String handlingRequestName(@RequestParam("studentName") String name, Model model) {
		name = name.toUpperCase();

		model.addAttribute("message", "Hello " + name);

		return "helloworld";
	}

}
