package demo.annotation.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theTennisCoach")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public String str="kiran ";
	
	public String str2=str;
	
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) {
		System.out.println("Constructor called");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Pratice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return str2+fortuneService.getFortune();
	}

	@PostConstruct
	public void doStartupStuff()
	{
		System.out.println("Did Start up stuff");
	}
	
	@PreDestroy
	public void KillTheObject()
	{
		System.out.println("Release the Kraken");
	}
}
