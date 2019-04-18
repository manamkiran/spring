package demo.annotation.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BadmintonCoach implements Coach{
	
	@Value("${email}")
	private String emailAddress;
	@Value("${team}")
	private String team;


	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Pratice Fore Hand";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
