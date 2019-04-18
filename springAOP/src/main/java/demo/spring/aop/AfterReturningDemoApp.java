package demo.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO dao = context.getBean(AccountDAO.class);

		List<Account> accounts=dao.findAccounts();
		
		System.out.println("Main program afterReturning");
		
		System.out.println(accounts);
		
		context.close();
	}
}
