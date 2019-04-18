package demo.annotation.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Pratice Defense";
	}

	@Override
	public String getDailyFortune() {
		return "Today's Fortune: " + fortuneService.getFortune();
	}

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Autowired
	@Qualifier("happyFortuneService")
	public void crazyMethod(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

}
