package demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class DBAspect {

	@Before("demo.spring.aop.aspect.AOPAspectExpressions.addPlayer()")
	public void dbAspect() {
		System.out.println("###########DB Aspect");
	}
}
