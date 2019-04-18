package demo.spring.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Its your day";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire)
		{
			throw new RuntimeException("No Fortune Today");
		}
		
		return getFortune();
	}
	
}
