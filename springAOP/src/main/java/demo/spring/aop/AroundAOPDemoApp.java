package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.service.FortuneService;

public class AroundAOPDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		FortuneService fortuneService = context.getBean(FortuneService.class);

		System.out.println("Calling Fortune Service");
		
		System.out.println(fortuneService.getFortune());

		System.out.println("Main program afterReturning");

		context.close();
	}
}
