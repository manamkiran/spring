package demo.annotation.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach coach = context.getBean("theTennisCoach", Coach.class);
		//Coach coach = context.getBean("cricketCoach", Coach.class);
		//Coach coach = context.getBean("badmintonCoach", Coach.class);
		

		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());

		context.close();
	}

}
