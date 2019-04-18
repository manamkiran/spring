package demo.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DuplicateController {

	@RequestMapping("/showForm")
	public String displayForm() {
		return "duplicate-form";
	}
}
