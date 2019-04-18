package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.PlayerDetailsDAO;

public class PlayerDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		PlayerDetailsDAO player = context.getBean(PlayerDetailsDAO.class);
		
		player.addPlayerDetails(new Account(),true);
		

		context.close();
	}
}
