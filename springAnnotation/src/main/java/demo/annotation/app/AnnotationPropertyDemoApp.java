package demo.annotation.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationPropertyDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BadmintonCoach coach = context.getBean("badmintonCoach", BadmintonCoach.class);
		

		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getTeam());
		
		System.out.println(coach.getEmailAddress());
		
		context.close();
	}

}
