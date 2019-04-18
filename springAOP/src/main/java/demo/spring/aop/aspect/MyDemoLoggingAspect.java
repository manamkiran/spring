package demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(public void demo.spring.aop.dao.AccountDAO.*(demo.spring.aop.Account,..))")
	private void pointCutExp() {}
	
	@Pointcut("execution(public void demo.spring.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(public void demo.spring.aop.dao.*.get*(..))")
	private void forDaoPackageGetters() {}
	
	@Pointcut("execution(public void demo.spring.aop.dao.*.set*(..))")
	private void forDaoPackageSetters() {}
	
	@Pointcut("forDaoPackage() && !(forDaoPackageGetters() || forDaoPackageSetters())")
	private void forDaoPackageNoGettersAndSetters() {}
	
	@Before("forDaoPackageNoGettersAndSetters()")
	private void advice()
	{
		System.out.println("################################ Method Advice ######################");
	}
	
	@Before("pointCutExp()")
	public void usingPointCut()
	{
		System.out.println("\n ************ Executing @Before advice on methods using Pointcut *******");
	}
	
	@Before("pointCutExp()")
	public void usingPointCut2()
	{
		System.out.println("\n ************ Executing @Before advice on methods using Pointcut exp 2*******");
	}

//	@Before("execution(public void updateAccount())")
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ************ Executing @Before advice on methods *******");
	}
	
	@Before("execution(public void demo.spring.aop.dao.AccountDAO.*(demo.spring.aop.Account))")
	public void beforeAccountDAOAddAccountAdvice()
	{
		System.out.println("\n ************ Executing @Before advice on addAcount *******");
	}
	
	//@Before("execution(public void add*())")
	@Before("execution(void add*())")
	public void beforeAnyAddMethodAdvice()
	{
		System.out.println("\n ************ Executing @Before advice on any add method *******");
	}
}
