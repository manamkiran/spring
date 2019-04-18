package demo.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aop.dao.AccountDAO;
import demo.spring.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO dao = context.getBean(AccountDAO.class);

		dao.addAccount();
		System.out.println("*********************************************");
		dao.setLevel("");
		dao.setName("");
		System.out.println("*********************************************");
		
		dao.addUserAccount(new Account());

		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);

		membershipDAO.addAccount();

		context.close();
	}
}
