package demo.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {

		System.out.println("Welcome to the Club");
	}

}
