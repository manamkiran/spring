package demo.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import demo.spring.aop.Account;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

	@Before("demo.spring.aop.aspect.AOPAspectExpressions.addPlayer()")
	public void loggingAspect(JoinPoint theJoinPoint) {
		System.out.println("###########Logging");

		MethodSignature sig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println(sig);

		Object[] methodArgs = theJoinPoint.getArgs();

		for (Object arg : methodArgs) {
			System.out.println(arg);
		}
	}

	@AfterReturning(pointcut = "execution(* demo.spring.aop.dao.AccountDAO.findAccounts(..))", returning = "listAccounts")
	public void accountLoggingAspect(JoinPoint theJoinPoint, List<Account> listAccounts) {
		System.out.println(theJoinPoint.getSignature().toShortString());

		System.out.println("Executing Aspect code");

		System.out.println("#####ListAccounts" + listAccounts);

		convertNamestoUpperCase(listAccounts);
	}

	private void convertNamestoUpperCase(List<Account> listAccounts) {

		for (Account account : listAccounts) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@AfterThrowing(pointcut = "execution(* demo.spring.aop.dao.AccountDAO.findAccounts(..))", throwing = "theException")
	public void accountExceptionLoggingAspect(JoinPoint theJoinPoint, Exception theException) {
		System.out.println(theJoinPoint.getSignature().toShortString());

		System.out.println("Executing Aspect code");

		System.out.println(theException);

	}

	@Around("execution(* getFortune*(..))")
	public Object AroundExceptionHandledGetFortuneService(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		System.out.println(theProceedingJoinPoint.getSignature().toShortString());

		long begin = System.currentTimeMillis();

		System.out.println("AroundExceptionHandledGetFortuneService");
		Object result;
		try {
			result = theProceedingJoinPoint.proceed();

		} catch (Exception e) {
			result = "Try again later";
		}
		long end = System.currentTimeMillis();

		long duration = end - begin;
		System.out.println("Duration is " + duration / 1000.0 + " seconds");

		return result;
	}

	@Around("execution(* getFortune*())")
	public Object AroundGetFortuneService(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		System.out.println(theProceedingJoinPoint.getSignature().toShortString());

		long begin = System.currentTimeMillis();
		
		System.out.println("AroundGetFortuneService");

		Object result;
		result = theProceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;
		System.out.println("Duration is " + duration / 1000.0 + " seconds");

		return result;
	}

}
