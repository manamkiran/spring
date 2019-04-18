package demo.annotation.app;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "Some Random Good thing will happen";
	}

}
