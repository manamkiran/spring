package demo.app;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do it: " + fortuneService.getFortune();
	}

	public void initMethodRandomName() {
		System.out.println("Do some stuff before giving object at startup");
	}

	public void destroyMethodRandomName() {
		System.out.println("Release the Kraken");
	}

}
