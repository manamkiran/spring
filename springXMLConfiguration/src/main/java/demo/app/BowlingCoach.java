package demo.app;

public class BowlingCoach implements Coach {

	
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	private FortuneService fortuneService;

	public BowlingCoach() {
	}
	
	public void setFortuneService(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Bowl 20 overs";
	}

	@Override
	public String getDailyFortune() {
		return "Today's Fortune is :" +fortuneService.getFortune();
	}

}
