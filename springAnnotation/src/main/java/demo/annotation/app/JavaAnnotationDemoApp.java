package demo.annotation.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaAnnotationDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfiguration.class);

		Coach coach = context.getBean("theTennisCoach", Coach.class);
		// Coach coach = context.getBean("cricketCoach", Coach.class);
		// Coach coach = context.getBean("badmintonCoach", Coach.class);

		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());

		context.close();
	}

}
