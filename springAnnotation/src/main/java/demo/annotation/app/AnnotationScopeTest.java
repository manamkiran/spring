package demo.annotation.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach coach = context.getBean("badmintonCoach", Coach.class);

		Coach badcoach = context.getBean("badmintonCoach", Coach.class);
		
		boolean result = coach == badcoach; 
		
		System.out.println( "Both Objects point to same location " + result);
		
		System.out.println(coach);
		System.out.println(badcoach);
		context.close();

	}

}
