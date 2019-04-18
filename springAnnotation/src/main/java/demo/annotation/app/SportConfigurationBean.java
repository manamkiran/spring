package demo.annotation.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfigurationBean {

	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}

	@Bean
	public Coach tennisCoach() {
		return new TennisCoach(happyFortuneService());
	}

}
