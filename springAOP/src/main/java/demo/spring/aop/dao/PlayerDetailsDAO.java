package demo.spring.aop.dao;

import org.springframework.stereotype.Component;

import demo.spring.aop.Account;

@Component
public class PlayerDetailsDAO {

	
	public void addPlayerDetails(Account account , boolean vip)
	{
		System.out.println("Adding Player Details");
	}
}
