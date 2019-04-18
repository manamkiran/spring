package demo.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.service.FortuneService;

public class AroundAOPWithLoggerDemoApp {
	
	private static Logger logger= Logger.getLogger(AroundAOPWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		FortuneService fortuneService = context.getBean(FortuneService.class);

		logger.info("Calling Fortune Service");
		
		logger.info(fortuneService.getFortune());

		logger.info("Main program afterReturning");

		context.close();
	}
}
