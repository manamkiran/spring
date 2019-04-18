package demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPAspectExpressions {
	
	@Pointcut("execution(void addPlayer*(..))")
	public void addPlayer() {}

}
