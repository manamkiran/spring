package com.spring.mvc.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger log = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.spring.mvc.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.spring.mvc.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.spring.mvc.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
	private void forAppFlow() {

	}

	@Before("forAppFlow()")
	public void Before(JoinPoint theJoinPoint) {
		log.info("########### Executing : " + theJoinPoint.getSignature().toShortString());
		System.out.println("########### Executing : " + theJoinPoint.getSignature().toShortString());
	}

}
