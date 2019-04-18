package demo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach myCoach = context.getBean("myCoach", Coach.class);

		boolean result = myCoach == theCoach;
		
		System.out.println("Pointing to the same Object : " + result);
		
		System.out.println("Memory Localtion of the theCoach : " + theCoach);
		System.out.println("Memory Localtion of the myCoach : " + myCoach);

		context.close();
	}

}
