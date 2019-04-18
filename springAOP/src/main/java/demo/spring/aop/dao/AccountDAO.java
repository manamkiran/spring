package demo.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import demo.spring.aop.Account;

@Component
public class AccountDAO {

	private String name;

	private String level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void addAccount() {
		System.out.println(getClass() + " : Adding account to Application");
	}

	public void addUserAccount(Account account) {
		System.out.println(getClass() + " : Adding User account to Application");
	}

	public List<Account> findAccounts() {
		return findAccounts(false);
	}

	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire == true) {
			throw new RuntimeException("You Tripped on the Wire ha ha ha .....");
		}
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Kiran", "Platinum"));
		accounts.add(new Account("Vihaan", "Platinum"));
		accounts.add(new Account("Priya", "Gold"));
		return accounts;
	}
}
