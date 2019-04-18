package demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class ServiceAPIAspect {

	@Before("demo.spring.aop.aspect.AOPAspectExpressions.addPlayer()")
	public void apiAnalytics() {
		System.out.println("########### API analytics");
	}
}
