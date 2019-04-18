package demo.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.service.FortuneService;

public class AroundAOPExceptionHandlerDemoApp {
	
	private static Logger logger= Logger.getLogger(AroundAOPExceptionHandlerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		FortuneService fortuneService = context.getBean(FortuneService.class);

		logger.info("Calling Fortune Service");
		
		logger.info(fortuneService.getFortune(true));

		logger.info("Main program afterReturning");

		context.close();
	}
}
