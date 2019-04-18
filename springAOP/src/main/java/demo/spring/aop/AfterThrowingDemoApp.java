package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO dao = context.getBean(AccountDAO.class);

		try {
		dao.findAccounts(true);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Main program afterThrowing");
		
		context.close();
	}
}
