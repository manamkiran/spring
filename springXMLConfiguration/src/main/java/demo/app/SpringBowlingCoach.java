package demo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBowlingCoach {
	

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BowlingCoach theCoach = context.getBean("myBowlingCoach",BowlingCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		context.close();
	}



}
